package ru.accounterio.cost_management.services.budgetManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.Balance;
import ru.accounterio.cost_management.interfaces.statistics.Periods;
import ru.accounterio.cost_management.repositories.postgres.TransactionRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BudgetStatisticsServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private BudgetStatisticsService budgetStatisticsService;

    public static final Set<Transaction> transactions = Set.of(
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-06T15:30:27")).value(15000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-06T16:30:27")).value(2700d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-06T17:30:27")).value(-500d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-06T18:30:27")).value(-300d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-07T23:30:27")).value(-9000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-08T12:30:27")).value(5000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-08T13:30:27")).value(1500d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-08T14:30:27")).value(-1500d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-09T15:30:27")).value(-3600d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-09T16:30:27")).value(200d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-09T17:30:27")).value(8000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-09T18:30:27")).value(-6000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-10T08:30:27")).value(-3000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-10T09:30:27")).value(1500d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-11T15:30:27")).value(2000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-11T16:30:27")).value(4000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-12T10:30:27")).value(-3000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-12T11:30:27")).value(-5000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-13T13:30:27")).value(-7000d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-14T15:30:27")).value(-500d).build(),
            Transaction.builder().stamp(LocalDateTime.parse("2023-05-15T16:30:27")).value(300d).build()
    );

    @Test
    public void getPeriodic_ifNullTransactions_returnEmpty() {
        Mockito.when(transactionRepository.findTransactionsByUser_Id(0L)).thenReturn(Collections.emptySet());
        assertTrue(budgetStatisticsService.getPeriodic(Periods.DAILY, 0L).isEmpty());
    }

    @Before
    public void prepareMock() {
        Mockito.when(transactionRepository.findTransactionsByUser_Id(0L)).thenReturn(BudgetStatisticsServiceTest.transactions);
    }

    @Test
    public void getPeriodic_ifPeriodDaily_returnCorrect() {
        SortedMap<LocalDate, Balance> await = new TreeMap<>(LocalDate::compareTo);
        await.put(LocalDate.parse("2023-05-06"), new Balance(17700d, -800d, 16900d));
        await.put(LocalDate.parse("2023-05-07"), new Balance(0d, -9000d, -9000d));
        await.put(LocalDate.parse("2023-05-08"), new Balance(6500d, -1500d, 5000d));
        await.put(LocalDate.parse("2023-05-09"), new Balance(8200d, -9600d, -1400d));
        await.put(LocalDate.parse("2023-05-10"), new Balance(1500d, -3000d, -1500d));
        await.put(LocalDate.parse("2023-05-11"), new Balance(6000d, 0d, 6000d));
        await.put(LocalDate.parse("2023-05-12"), new Balance(0d, -8000d, -8000d));
        await.put(LocalDate.parse("2023-05-13"), new Balance(0d, -7000d, -7000d));
        await.put(LocalDate.parse("2023-05-14"), new Balance(0d, -500d, -500d));
        await.put(LocalDate.parse("2023-05-15"), new Balance(300d, 0d, 300d));
        await.putAll(
                Stream.iterate(
                        Map.entry(LocalDate.parse("2023-05-16"), new Balance(0d, 0d, 0d)), t -> t.getKey().isBefore(LocalDate.now()),
                        t -> Map.entry(t.getKey().plusDays(1), new Balance(0d, 0d, 0d)))
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        assertEquals(await, budgetStatisticsService.getPeriodic(Periods.DAILY, 0L));
    }

//    @Test
//    public void getPeriodic_ifPeriodWeekly_returnCorrect() {
//        SortedMap<LocalDate, Balance> await = new TreeMap<>(LocalDate::compareTo);
//        await.put(LocalDate.parse("2023-05-06"), new Balance(39900d, -31900d, 8000d));
//        await.put(LocalDate.parse("2023-05-13"), new Balance(300d, -7500d, -7200d));
//        assertEquals(await, budgetStatisticsService.getPeriodic(Periods.WEEKLY, 0L));
//    }

    // TODO: 23.10.2023 Week Period test

    @Test
    public void getPeriodic_defaultPeriod_isEqualsDailyPeriod() {
        SortedMap<LocalDate, Balance> await = new TreeMap<>(LocalDate::compareTo);
        await.put(LocalDate.parse("2023-05-06"), new Balance(17700d, -800d, 16900d));
        await.put(LocalDate.parse("2023-05-07"), new Balance(0d, -9000d, -9000d));
        await.put(LocalDate.parse("2023-05-08"), new Balance(6500d, -1500d, 5000d));
        await.put(LocalDate.parse("2023-05-09"), new Balance(8200d, -9600d, -1400d));
        await.put(LocalDate.parse("2023-05-10"), new Balance(1500d, -3000d, -1500d));
        await.put(LocalDate.parse("2023-05-11"), new Balance(6000d, 0d, 6000d));
        await.put(LocalDate.parse("2023-05-12"), new Balance(0d, -8000d, -8000d));
        await.put(LocalDate.parse("2023-05-13"), new Balance(0d, -7000d, -7000d));
        await.put(LocalDate.parse("2023-05-14"), new Balance(0d, -500d, -500d));
        await.put(LocalDate.parse("2023-05-15"), new Balance(300d, 0d, 300d));
        await.putAll(
                Stream.iterate(
                                Map.entry(LocalDate.parse("2023-05-16"), new Balance(0d, 0d, 0d)), t -> t.getKey().isBefore(LocalDate.now()),
                                t -> Map.entry(t.getKey().plusDays(1), new Balance(0d, 0d, 0d)))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        assertEquals(await, budgetStatisticsService.getPeriodic(null, 0L));
    }
}
