package ru.accounterio.telegram_bot.tele_core.dto;

import java.time.Instant;

public record Consultation(String value, Instant stamp) {
}
