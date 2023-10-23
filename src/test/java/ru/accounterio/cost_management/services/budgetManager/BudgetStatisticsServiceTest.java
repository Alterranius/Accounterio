package ru.accounterio.cost_management.services.budgetManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.accounterio.cost_management.repositories.postgres.TransactionRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BudgetStatisticsServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private BudgetStatisticsService budgetStatisticsService;

    @Test
    public void getPeriodic_ifNullTransactions_returnEmpty() {

    }

    @Test
    public void getPeriodic_ifPeriodDaily_returnCorrect() {

    }

    @Test
    public void getPeriodic_ifPeriodWeekly_returnCorrect() {

    }

    @Test
    public void getPeriodic_defaultPeriod_isEqualsDailyPeriod() {

    }
}
