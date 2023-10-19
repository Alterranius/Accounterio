package ru.accounterio.receiptai.receiptai_processor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.receiptai.receiptai_processor.interfaces.ReceiptProcessor;

@Service
public class ReceiptProcessorSimple implements ReceiptProcessor {
    private final CostSetProducer costSetProducer;

    @Autowired
    public ReceiptProcessorSimple(CostSetProducer costSetProducer) {
        this.costSetProducer = costSetProducer;
    }
}
