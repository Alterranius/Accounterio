package ru.accounterio.cost_management.dto;

import ru.accounterio.cost_management.domains.Transaction;

import java.util.SortedSet;

public record TransactionChain(Long userId, SortedSet<Transaction> transactionSet) {
}
