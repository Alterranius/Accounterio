package ru.accounterio.receiptai.receiptai_processor.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.domains.RecognizableReceipt;
import ru.accounterio.receiptai.receiptai_processor.dto.ReceiptImage;
import ru.accounterio.receiptai.receiptai_processor.interfaces.ReceiptProcessor;
import ru.accounterio.receiptai.receiptai_processor.services.classificator.ClassificationCostService;
import ru.accounterio.receiptai.receiptai_processor.services.factories.ReceiptComplector;
import ru.accounterio.receiptai.receiptai_processor.services.vision.RecognitionService;
import ru.accounterio.receiptai.receiptai_processor.tasks.Task;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class ReceiptProcessorSimple implements ReceiptProcessor {
    private final CostSetProducer costSetProducer;
    private final ClassificationCostService classificationService;
    private final ReceiptComplector receiptComplector;
    private final RecognitionService recognitionService;
    private final AccounterioCoreMessager accounterioCoreMessager;

    @Autowired
    public ReceiptProcessorSimple(CostSetProducer costSetProducer, ClassificationCostService classificationService, ReceiptComplector receiptComplector, RecognitionService recognitionService, AccounterioCoreMessager accounterioCoreMessager) {
        this.costSetProducer = costSetProducer;
        this.classificationService = classificationService;
        this.receiptComplector = receiptComplector;
        this.recognitionService = recognitionService;
        this.accounterioCoreMessager = accounterioCoreMessager;
    }

    @RabbitListener(queues = {"receipt-task-queue"})
    public void consumeReceiptTasks(Task<ReceiptImage, CostSet> receiptTask) {
        receiptTask.execute(this::processReceipt).ifPresent(this::successCallback);
    }

    public CostSet processReceipt(ReceiptImage receiptImage) {
        AtomicReference<CostSet> result = new AtomicReference<>();
        RecognizableReceipt.of(receiptImage).ifPresent(r -> result.set(classificationService.classify(receiptComplector.complect(recognitionService.recognize(r)))));
        return result.get();
    }

    public void successCallback(CostSet costSet) {
        costSetProducer.sendMessage(costSet);
        accounterioCoreMessager.notifySuccessProcessing(costSet.userId());
    }
}
