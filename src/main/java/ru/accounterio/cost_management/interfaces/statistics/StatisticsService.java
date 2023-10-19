package ru.accounterio.cost_management.interfaces.statistics;

import ru.accounterio.cost_management.dto.Balance;

import java.time.LocalDate;
import java.util.Map;

public interface StatisticsService {
    Map<LocalDate, Balance> getPeriodic(Periods period, Long userId) throws StatisticsServiceException;
}
