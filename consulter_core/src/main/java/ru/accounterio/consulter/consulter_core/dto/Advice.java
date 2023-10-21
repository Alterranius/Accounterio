package ru.accounterio.consulter.consulter_core.dto;

import java.io.IOException;
import java.time.Instant;

public record Advice(Long userId, String value, Instant stamp) implements Response {
    public static Advice exceptionBody(Long userId, IOException e) {
        return new Advice(userId, e.getMessage(), Instant.now());
    }
}
