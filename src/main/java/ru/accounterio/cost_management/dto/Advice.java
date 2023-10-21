package ru.accounterio.cost_management.dto;

import java.io.Serializable;
import java.time.Instant;

public record Advice(String value, Instant stamp) implements Serializable {
}
