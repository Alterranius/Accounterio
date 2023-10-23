package ru.accounterio.cost_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Snapshot of finance balance values used for charts")
public record Balance(double income, double expense, double value) implements Serializable {
}
