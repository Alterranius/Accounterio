package ru.accounterio.consulter.consulter_core.dto;

import java.io.IOException;
import java.time.Instant;

public record Advice(String value, Instant stamp) {
    public static Advice exceptionBody(IOException e) {
        return new Advice(e.getMessage(), Instant.now());
    }
}
