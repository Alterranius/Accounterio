package ru.accounterio.receiptai.receiptai_processor.dto;

import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;

import java.io.Serializable;
import java.time.LocalDateTime;

public record Receipt(String code,
                      String supplier,
                      String paymentMethod,
                      LocalDateTime date,
                      CostSet costSet
                      ) implements Serializable {
}
