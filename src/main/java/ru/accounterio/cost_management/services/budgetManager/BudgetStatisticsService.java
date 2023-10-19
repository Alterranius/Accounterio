package ru.accounterio.cost_management.services.budgetManager;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.dto.Balance;
import ru.accounterio.cost_management.interfaces.statistics.Periods;
import ru.accounterio.cost_management.interfaces.statistics.StatisticsService;
import ru.accounterio.cost_management.repositories.postgres.TransactionRepository;

import java.time.LocalDate;
import java.util.Map;

@Service
@Log4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class BudgetStatisticsService implements StatisticsService {
    TransactionRepository transactionRepository;

    @Override
    public Map<LocalDate, Balance> getPeriodic(Periods period, Long userId) {
        return null;
    }
}
