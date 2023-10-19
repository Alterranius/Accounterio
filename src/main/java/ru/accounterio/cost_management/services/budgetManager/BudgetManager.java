package ru.accounterio.cost_management.services.budgetManager;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.domains.Category;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.Budget;
import ru.accounterio.cost_management.dto.TransactionChain;
import ru.accounterio.cost_management.interfaces.budget.BudgetService;
import ru.accounterio.cost_management.repositories.postgres.CategoryRepository;
import ru.accounterio.cost_management.repositories.postgres.TransactionRepository;

import java.util.List;

@Service
@Log4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class BudgetManager implements BudgetService {
    TransactionRepository transactionRepository;
    CategoryRepository categoryRepository;

    @Override
    public Budget getBudget(Long userId) {
        return null;
    }

    @Override
    public TransactionChain getTransactions(Long userId) {
        return null;
    }

    @Override
    public TransactionChain getIncomes(Long userId) {
        return null;
    }

    @Override
    public TransactionChain getExpenses(Long userId) {
        return null;
    }

    @Override
    public Long addTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public void updateTransactionValue(Long id, double value) {

    }

    @Override
    public void updateTransactionCategory(Long transId, int categoryId) {

    }

    @Override
    public List<Category> getCategories(Long userId) {
        return null;
    }
}
