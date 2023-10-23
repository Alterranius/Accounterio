package ru.accounterio.receiptai.receiptai_processor.services.factories;

import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Component;
import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.dto.RecognitionResult;
import ru.accounterio.receiptai.receiptai_processor.interfaces.util.Complector;

@Component
public class ReceiptComplector implements Complector<CostSet> {
    @Timed("complectionTime")
    @Override
    public CostSet complect(RecognitionResult from) {
        return null;
    }
}
