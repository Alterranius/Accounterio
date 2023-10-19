package ru.accounterio.cost_management.interfaces.budget;

import ru.accounterio.cost_management.domains.Category;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.Budget;
import ru.accounterio.cost_management.dto.TransactionChain;

import java.util.List;

public interface BudgetService {
    Budget getBudget(Long userId) throws BudgetServiceException;
    TransactionChain getTransactions(Long userId) throws BudgetServiceException;
    TransactionChain getIncomes(Long userId) throws BudgetServiceException;
    TransactionChain getExpenses(Long userId) throws BudgetServiceException;
    Long addTransaction(Transaction transaction) throws BudgetServiceException;
    void deleteTransaction(Long id) throws BudgetServiceException;
    void updateTransactionValue(Long id, double value) throws BudgetServiceException;
    void updateTransactionCategory(Long transId, int categoryId) throws BudgetServiceException;
    List<Category> getCategories(Long userId) throws BudgetServiceException;

}
