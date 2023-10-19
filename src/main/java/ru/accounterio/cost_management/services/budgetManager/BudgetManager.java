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

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
@Log4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class BudgetManager implements BudgetService {
    TransactionRepository transactionRepository;
    CategoryRepository categoryRepository;

    @Override
    public Budget getBudget(Long userId) {
        return new Budget(transactionRepository.findTransactionsByUser_Id(userId).stream().mapToDouble(Transaction::getValue).sum());
    }

    @Override
    public TransactionChain getTransactions(Long userId) {
        return new TransactionChain(userId, Collections.unmodifiableSortedSet(new TreeSet<>(transactionRepository.findTransactionsByUser_Id(userId))));
    }

    @Override
    public TransactionChain getIncomes(Long userId) {
        return new TransactionChain(userId, Collections.unmodifiableSortedSet(new TreeSet<>(transactionRepository.findTransactionsByUser_Id(userId).stream()
                .filter(Transaction::isIncome).collect(Collectors.toSet()))));
    }

    @Override
    public TransactionChain getExpenses(Long userId) {
        return new TransactionChain(userId, Collections.unmodifiableSortedSet(new TreeSet<>(transactionRepository.findTransactionsByUser_Id(userId).stream()
                .filter(Transaction::isExpense).collect(Collectors.toSet()))));
    }

    @Override
    public Long addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction).getId();
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.findById(id).ifPresent(transactionRepository::delete);
    }

    @Override
    public void updateTransactionValue(Long id, double value) {
        transactionRepository.findById(id).ifPresent(t -> {
            t.setValue(value);
            transactionRepository.save(t);
        });
    }

    @Override
    public void updateTransactionCategory(Long transId, int categoryId) {
        transactionRepository.findById(transId).ifPresent(trans -> {
            categoryRepository.findById(categoryId).ifPresent(cat -> {
                trans.setCategory(cat);
                cat.getTransactions().add(trans);
            });
            transactionRepository.save(trans);
        });
    }

    @Override
    public Set<Category> getCategories(Long userId) {
        return categoryRepository.findCategoriesByUser_Id(userId);
    }
}
