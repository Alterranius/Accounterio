package ru.accounterio.receiptai.receiptai_processor.services.factories;

import org.springframework.stereotype.Component;
import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.dto.RecognitionResult;
import ru.accounterio.receiptai.receiptai_processor.interfaces.Complector;

@Component
public class ReceiptComplector implements Complector<CostSet> {
    @Override
    public CostSet complect(RecognitionResult from) {
        return null;
    }
}
