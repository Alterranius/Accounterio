package ru.accounterio.receiptai.receiptai_processor.domains;

import ru.accounterio.receiptai.receiptai_processor.dto.ReceiptImage;

import java.awt.image.BufferedImage;
import java.util.Optional;

public class RecognizableReceipt implements Recognizable {
    private RecognizableReceipt() {
    }

    public static Optional<RecognizableReceipt> of(ReceiptImage receiptImage) {
        return Optional.empty();
    }

    @Override
    public BufferedImage getToken() {
        return null;
    }
}
