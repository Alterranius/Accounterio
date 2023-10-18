package ru.accounterio.receiptai.receiptai_processor.services.vision.recognizers;

import org.springframework.stereotype.Component;
import ru.accounterio.receiptai.receiptai_processor.domains.Recognizable;
import ru.accounterio.receiptai.receiptai_processor.dto.RecognitionResult;
import ru.accounterio.receiptai.receiptai_processor.interfaces.Recognizer;

@Component
public class ReceiptRecognizer implements Recognizer {
    @Override
    public RecognitionResult recognize(Recognizable r) {
        return null;
    }
}
