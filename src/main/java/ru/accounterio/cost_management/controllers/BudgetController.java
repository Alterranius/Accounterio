package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.domains.Category;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.Budget;
import ru.accounterio.cost_management.dto.TransactionChain;
import ru.accounterio.cost_management.interfaces.budget.BudgetService;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/budget")
@Tag(name = "Core API", description = "Used as external gateway")
public class BudgetController {
    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Operation(summary = "Get User Budget at the moment")
    @GetMapping("/getBudget/{user_id}")
    public Budget getBudget(@PathVariable("user_id") Long id) {

    }

    @Operation(summary = "Get all User Transactions")
    @GetMapping("/getTransactions/{user_id}")
    public TransactionChain getTransactions(@PathVariable("user_id") Long id) {

    }

    @Operation(summary = "Get all User incomes")
    @GetMapping("/getIncomes/{user_id}")
    public TransactionChain getIncomes(@PathVariable("user_id") Long id) {

    }

    @Operation(summary = "Get all User expenses")
    @GetMapping("/getExpenses/{user_id}")
    public TransactionChain getExpenses(@PathVariable("user_id") Long id) {

    }

    @Operation(summary = "Add new income")
    @PostMapping("/addIncome")
    public ResponseEntity<HttpStatus> addIncome(@RequestBody Transaction transaction) {

    }

    @Operation(summary = "Add new expense")
    @PostMapping("/addExpense")
    public ResponseEntity<HttpStatus> addExpense(@RequestBody Transaction transaction) {

    }

    @Operation(summary = "Delete User Transaction")
    @DeleteMapping("/deleteTransaction/{trans_id}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable("trans_id") Long id) {

    }

    @Operation(summary = "Update Transaction value")
    @PatchMapping("/updateValue/{trans_id}")
    public ResponseEntity<HttpStatus> updateTransactionValue(@PathVariable("trans_id") Long id, @RequestBody double value) {

    }

    @Operation(summary = "Update Transaction Category")
    @PatchMapping("/updateCategory/{trans_id}")
    public ResponseEntity<HttpStatus> updateTransactionCategory(@PathVariable("trans_id") Long transId, @RequestBody int categoryId) {

    }

    @Operation(summary = "Get User Categories")
    @GetMapping("/getCategories/{user_id}")
    public Set<Category> getCategories(@PathVariable("user_id") Long id) {

    }
}
