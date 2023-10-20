package ru.accounterio.cost_management.dto.receipt;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public record CostSet(Long userId, Map<Position, Quantity> costs, LocalDateTime stamp, Supplier supplier, double tax) implements Serializable {
    public double subtotal() {
        return 0d;
    }

    public double total() {
        return 0d;
    }
}
