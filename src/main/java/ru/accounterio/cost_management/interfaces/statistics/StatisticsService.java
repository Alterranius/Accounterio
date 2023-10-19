package ru.accounterio.cost_management.interfaces.statistics;

import ru.accounterio.cost_management.dto.Balance;

import java.time.LocalDate;
import java.util.SortedMap;

public interface StatisticsService {
    SortedMap<LocalDate, Balance> getPeriodic(Periods period, Long userId) throws StatisticsServiceException;
}
