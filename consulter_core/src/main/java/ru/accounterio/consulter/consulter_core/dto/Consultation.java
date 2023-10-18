package ru.accounterio.consulter.consulter_core.dto;

import java.io.IOException;
import java.time.Instant;

public record Consultation(String value, Instant stamp) {
    public static Consultation exceptionBody(IOException e) {
        return new Consultation(e.getMessage(), Instant.now());
    }
}
