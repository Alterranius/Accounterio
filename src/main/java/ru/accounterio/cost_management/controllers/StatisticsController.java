package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.dto.Balance;
import ru.accounterio.cost_management.interfaces.statistics.StatisticsService;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/statistics")
@Tag(name = "Statistics API", description = "Used as external gateway")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Operation(summary = "Get periodic chart of User Transactions")
    @GetMapping("/balance/{period}/{user_id}")
    public Map<LocalDate, Balance> getPeriodicChart(@PathVariable("period") String period, @PathVariable("user_id") Long userId) {

    }
}
