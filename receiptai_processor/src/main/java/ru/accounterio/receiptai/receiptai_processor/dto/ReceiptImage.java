package ru.accounterio.receiptai.receiptai_processor.dto;

import java.io.Serializable;
import java.time.Instant;

public record ReceiptImage(Long userId, Instant stamp, byte[] image) implements Serializable {
}
