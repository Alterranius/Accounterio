package ru.accounterio.telegram_bot.tele_core.dto;

import java.time.Instant;

public record Callback(Long userId, String value, Instant stamp) {
}
