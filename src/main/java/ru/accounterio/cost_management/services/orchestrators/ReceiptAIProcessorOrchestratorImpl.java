package ru.accounterio.cost_management.services.orchestrators;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.dto.ReceiptImage;
import ru.accounterio.cost_management.interfaces.orchestrators.OrchestrationException;
import ru.accounterio.cost_management.interfaces.orchestrators.ReceiptAIProcessorOrchestrator;
import ru.accounterio.cost_management.services.orchestrators.producers.ReceiptProcessorTaskProducer;
import ru.accounterio.cost_management.services.orchestrators.tasks.TaskFactory;
import ru.accounterio.cost_management.services.orchestrators.tasks.commands.ProcessReceiptCommand;

@Service
@Log4j
public class ReceiptAIProcessorOrchestratorImpl implements ReceiptAIProcessorOrchestrator {
    private final ReceiptProcessorTaskProducer receiptTaskProducer;

    @Autowired
    public ReceiptAIProcessorOrchestratorImpl(ReceiptProcessorTaskProducer receiptTaskProducer) {
        this.receiptTaskProducer = receiptTaskProducer;
    }

    @Override
    public void orchestrateAddReceiptBP(ReceiptImage receiptImage) throws OrchestrationException {
        receiptTaskProducer.sendMessage(new TaskFactory().withCommand(new ProcessReceiptCommand()).createReceiptProcessTask(receiptImage));
    }

    @Override
    public void orchestrateEndReceiptBP(Long userId) throws OrchestrationException {

    }
}
