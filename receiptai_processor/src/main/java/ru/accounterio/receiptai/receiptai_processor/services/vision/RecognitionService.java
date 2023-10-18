package ru.accounterio.receiptai.receiptai_processor.services.vision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accounterio.receiptai.receiptai_processor.services.vision.recognizers.ReceiptRecognizer;

@Service
public class RecognitionService {
    private final ReceiptRecognizer receiptRecognizer;

    @Autowired
    public RecognitionService(ReceiptRecognizer receiptRecognizer) {
        this.receiptRecognizer = receiptRecognizer;
    }
}
