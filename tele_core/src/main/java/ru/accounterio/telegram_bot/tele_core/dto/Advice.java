package ru.accounterio.telegram_bot.tele_core.dto;

import java.time.Instant;

public record Advice(Long userId, String value, Instant stamp) {
}
