package ru.accounterio.consulter.consulter_core.dto;

import java.io.IOException;
import java.time.Instant;

public record Consultation(Long userId, String value, Instant stamp) implements Response {
    public static Consultation exceptionBody(Long userId, IOException e) {
        return new Consultation(userId, e.getMessage(), Instant.now());
    }
}
