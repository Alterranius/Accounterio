package ru.accounterio.cost_management.dto.receipt;

import java.io.Serializable;
import java.util.Map;

public record CostSet(Map<Position, Quantity> costs, double subtotal, double tax, double total) implements Serializable {
}
