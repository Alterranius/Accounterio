package ru.accounterio.cost_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.accounterio.cost_management.domains.Transaction;

import java.io.Serializable;
import java.util.SortedSet;

@Schema(description = "Chain of User Transactions, view-style")
public record TransactionChain(Long userId, SortedSet<Transaction> transactionSet) implements Serializable {
}
