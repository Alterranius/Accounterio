package ru.accounterio.cost_management.services.budgetManager;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.cost_management.domains.Transaction;
import ru.accounterio.cost_management.dto.receipt.CostSet;
import ru.accounterio.cost_management.interfaces.budget.BudgetService;

@Component
public class TransactionQueueConsumer {
    private final BudgetService budgetService;

    @Autowired
    public TransactionQueueConsumer(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @RabbitListener(queues = {"transaction-queue"})
    public void consume(CostSet costSet) {
        // TODO: 20.10.2023 consuming costSets
    }
}
