package ru.accounterio.telegram_bot.tele_core.dto;

import java.awt.image.BufferedImage;
import java.time.Instant;

public record ReceiptImage(int userId, Instant stamp, BufferedImage image) {
}
