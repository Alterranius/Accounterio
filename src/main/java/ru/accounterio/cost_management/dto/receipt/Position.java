package ru.accounterio.cost_management.dto.receipt;

import java.io.Serializable;

public record Position(String name, double price, Category category) implements Serializable {
}
