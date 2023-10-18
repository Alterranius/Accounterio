package ru.accounterio.receiptai.receiptai_processor.dto;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.Instant;

public record ReceiptImage(Long userId, Instant stamp, BufferedImage image) implements Serializable {
}
