package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.accounterio.cost_management.dto.Balance;
import ru.accounterio.cost_management.interfaces.statistics.Periods;
import ru.accounterio.cost_management.interfaces.statistics.StatisticsService;
import ru.accounterio.cost_management.interfaces.statistics.StatisticsServiceException;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/statistics")
@Tag(name = "Statistics API", description = "Used as external gateway")
public class StatisticsController {
    private final StatisticsService statisticsService;
    public static final String STATISTICS_SERVICE_MESSAGE = "Во время сбора статистики произошла ошибка:(";

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Operation(summary = "Get periodic chart of User Transactions")
    @GetMapping("/balance/{period}/{user_id}")
    public Map<LocalDate, Balance> getPeriodicChart(@PathVariable("period") String period, @PathVariable("user_id") Long userId) {
        try {
            return statisticsService.getPeriodic(Periods.getByName(period), userId);
        } catch (StatisticsServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    STATISTICS_SERVICE_MESSAGE,
                    e
            );
        }
    }
}
