package ru.accounterio.cost_management.dto;

import java.io.Serializable;
import java.time.Instant;

public record Consultation(String value, Instant stamp) implements Serializable {
}
