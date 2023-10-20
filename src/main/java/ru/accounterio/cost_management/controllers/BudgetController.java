package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.accounterio.cost_management.domains.Category;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.Budget;
import ru.accounterio.cost_management.dto.TransactionChain;
import ru.accounterio.cost_management.interfaces.budget.BudgetService;
import ru.accounterio.cost_management.interfaces.budget.BudgetServiceException;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/budget")
@Tag(name = "Core API", description = "Used as external gateway")
public class BudgetController {
    private final BudgetService budgetService;
    public static final String NOT_FOUND_MESSAGE = "Данных не найдено:(";
    public static final String INTERNAL_SERVICE_MESSAGE = "Произошла ошибка работы сервиса:(";

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Operation(summary = "Get User Budget at the moment")
    @GetMapping("/getBudget/{user_id}")
    public Budget getBudget(@PathVariable("user_id") Long id) {
        try {
            return budgetService.getBudget(id);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND_MESSAGE,
                    e
            );
        }
    }

    @Operation(summary = "Get all User Transactions")
    @GetMapping("/getTransactions/{user_id}")
    public TransactionChain getTransactions(@PathVariable("user_id") Long id) {
        try {
            return budgetService.getTransactions(id);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND_MESSAGE,
                    e
            );
        }
    }

    @Operation(summary = "Get all User incomes")
    @GetMapping("/getIncomes/{user_id}")
    public TransactionChain getIncomes(@PathVariable("user_id") Long id) {
        try {
            return budgetService.getIncomes(id);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND_MESSAGE,
                    e
            );
        }
    }

    @Operation(summary = "Get all User expenses")
    @GetMapping("/getExpenses/{user_id}")
    public TransactionChain getExpenses(@PathVariable("user_id") Long id) {
        try {
            return budgetService.getExpenses(id);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND_MESSAGE,
                    e
            );
        }
    }

    @Operation(summary = "Add new income")
    @PostMapping("/addIncome")
    public ResponseEntity<HttpStatus> addIncome(@RequestBody Transaction transaction) {
        try {
            budgetService.addTransaction(transaction);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    INTERNAL_SERVICE_MESSAGE,
                    e
            );
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Add new expense")
    @PostMapping("/addExpense")
    public ResponseEntity<HttpStatus> addExpense(@RequestBody Transaction transaction) {
        try {
            transaction.setValue((-1d) * transaction.getValue());
            budgetService.addTransaction(transaction);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    INTERNAL_SERVICE_MESSAGE,
                    e
            );
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Delete User Transaction")
    @DeleteMapping("/deleteTransaction/{trans_id}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable("trans_id") Long id) {
        try {
            budgetService.deleteTransaction(id);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    INTERNAL_SERVICE_MESSAGE,
                    e
            );
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Update Transaction value")
    @PatchMapping("/updateValue/{trans_id}")
    public ResponseEntity<HttpStatus> updateTransactionValue(@PathVariable("trans_id") Long id, @RequestBody double value) {
        try {
            budgetService.updateTransactionValue(id, value);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    INTERNAL_SERVICE_MESSAGE,
                    e
            );
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get User Categories")
    @GetMapping("/getCategories/{user_id}")
    public Set<Category> getCategories(@PathVariable("user_id") Long id) {
        try {
            return budgetService.getCategories(id);
        } catch (BudgetServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    NOT_FOUND_MESSAGE,
                    e
            );
        }
    }
}
