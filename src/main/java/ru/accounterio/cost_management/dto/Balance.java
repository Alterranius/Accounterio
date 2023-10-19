package ru.accounterio.cost_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "Snapshot of TransactionChains, used for charts")
public record Balance(TransactionChain... transactionChains) implements Serializable {
}
