package ru.accounterio.telegram_bot.tele_core.dto;

import java.time.Instant;

public record ReceiptImage(Long userId, Instant stamp, byte[] image) {
}
