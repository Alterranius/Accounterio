package ru.accounterio.cost_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Snapshot of momentum User Budget")
public record Budget(double value) implements Serializable {
}
