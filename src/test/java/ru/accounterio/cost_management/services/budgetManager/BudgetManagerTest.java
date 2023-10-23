package ru.accounterio.cost_management.services.budgetManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.accounterio.cost_management.config.AccounterioCoreTestContainers;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.repositories.postgres.TransactionRepository;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AccounterioCoreTestContainers.class})
@RunWith(value = MockitoJUnitRunner.class)
public class BudgetManagerTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private BudgetManager budgetManager;

    @Before
    public void prepareMock() {
        Mockito.when(transactionRepository.findTransactionsByUser_Id(0L)).thenReturn(BudgetStatisticsServiceTest.transactions);
    }

    @Test
    public void getIncomes_returnCorrect() {
        Mockito.when(transactionRepository.findTransactionsByUser_Id(0L)).thenReturn(BudgetStatisticsServiceTest.transactions);

        assertEquals(BudgetStatisticsServiceTest.transactions.stream().filter(Transaction::isIncome).collect(Collectors.toSet()),
                budgetManager.getIncomes(0L).transactionSet());
    }

    @Test
    public void getExpenses_returnCorrect() {
        assertEquals(BudgetStatisticsServiceTest.transactions.stream().filter(Transaction::isExpense).collect(Collectors.toSet()),
                budgetManager.getExpenses(0L).transactionSet());
    }

    @Test
    public void getBudget_returnCorrect() {
        assertEquals(BudgetStatisticsServiceTest.transactions.stream().mapToDouble(Transaction::getValue).sum(),
                budgetManager.getBudget(0L).value());
    }

}