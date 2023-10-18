package ru.accounterio.cost_management.controllers;

import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.dto.Budget;
import ru.accounterio.cost_management.dto.TransactionChain;

@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {
    @GetMapping("/getBudget/{user_id}")
    @ResponseBody
    public Budget getBudget(@PathVariable("user_id") Long id) {

    }

    @GetMapping("/getTransactions/{user_id}")
    @ResponseBody
    public TransactionChain getTransactions(@PathVariable("user_id") Long id) {

    }

    @GetMapping("/getIncomes/{user_id}")
    @ResponseBody
    public TransactionChain getIncomes(@PathVariable("user_id") Long id) {

    }

    @GetMapping("/getExpenses/{user_id}")
    @ResponseBody
    public TransactionChain getExpenses(@PathVariable("user_id") Long id) {

    }
}
