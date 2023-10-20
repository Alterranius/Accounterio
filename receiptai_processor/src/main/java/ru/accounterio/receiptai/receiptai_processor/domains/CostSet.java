package ru.accounterio.receiptai.receiptai_processor.domains;

import java.io.Serializable;
import java.util.Map;

public record CostSet(Long userId, Map<Position, Quantity> costs, double subtotal, double tax, double total) implements Serializable {
}
