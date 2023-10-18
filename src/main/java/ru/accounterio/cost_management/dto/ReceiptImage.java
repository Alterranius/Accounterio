package ru.accounterio.cost_management.dto;

import java.awt.image.BufferedImage;
import java.time.Instant;

public record ReceiptImage(int userId, Instant stamp, BufferedImage image) {
}
