package ru.accounterio.cost_management.services.budgetManager;

import io.micrometer.core.annotation.Timed;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.Balance;
import ru.accounterio.cost_management.interfaces.statistics.Periods;
import ru.accounterio.cost_management.interfaces.statistics.StatisticsService;
import ru.accounterio.cost_management.repositories.postgres.TransactionRepository;

import java.time.LocalDate;
import java.util.*;

@Service
@Log4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class BudgetStatisticsService implements StatisticsService {
    TransactionRepository transactionRepository;

    @Timed("statisticsProcessingTime")
    @Override
    public SortedMap<LocalDate, Balance> getPeriodic(Periods period, Long userId) {
        PriorityQueue<Transaction> userTransactions = new PriorityQueue<>(transactionRepository.findTransactionsByUser_Id(userId));
        SortedMap<LocalDate, Balance> result = new TreeMap<>(LocalDate::compareTo);
        if (userTransactions.isEmpty()) return result;

        for (LocalDate date = userTransactions.peek().getStamp().toLocalDate(); date.isBefore(LocalDate.now()); date = dateIncrement(date, period)) {
            double income = 0d;
            double expense = 0d;
            while (userTransactions.peek().getStamp().toLocalDate().equals(date)) {
                Transaction transaction = userTransactions.poll();
                if (transaction.isExpense()) {
                    income += transaction.getValue();
                } else {
                    expense += transaction.getValue();
                }
            }
            result.put(date, new Balance(income, expense, income + expense));
        }
        return result;
    }

    private LocalDate dateIncrement(LocalDate date, Periods period) {
        return switch (period) {
            case WEEKLY -> date.plusWeeks(1);
            case MONTHLY -> date.plusMonths(1);
            default -> date.plusDays(1);
        };
    }
}
