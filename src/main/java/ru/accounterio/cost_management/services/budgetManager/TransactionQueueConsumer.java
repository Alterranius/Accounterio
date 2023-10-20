package ru.accounterio.cost_management.services.budgetManager;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.cost_management.domains.*;
import ru.accounterio.cost_management.dto.receipt.CostSet;
import ru.accounterio.cost_management.dto.receipt.Quantity;
import ru.accounterio.cost_management.interfaces.budget.BudgetService;
import ru.accounterio.cost_management.interfaces.budget.BudgetServiceException;
import ru.accounterio.cost_management.interfaces.user.UserService;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TransactionQueueConsumer {
    private final BudgetService budgetService;
    private final UserService userService;

    @Autowired
    public TransactionQueueConsumer(BudgetService budgetService, UserService userService) {
        this.budgetService = budgetService;
        this.userService = userService;
    }

    @RabbitListener(queues = {"transaction-queue"})
    public void consume(CostSet costSet) {
        Optional<User> user = userService.getUser(costSet.userId());
        if (user.isEmpty()) return;
        Transaction transaction = createTransaction(costSet, user.get());
        try {
            budgetService.addTransaction(transaction);
        } catch (BudgetServiceException ignored) {
        }
    }

    private Transaction createTransaction(CostSet costSet, User user) {
        return Transaction.builder()
                .stamp(costSet.stamp())
                .value(costSet.total())
                .positions(costSet.costs().entrySet().stream().map(p -> positionFromDto(p, user)).collect(Collectors.toSet()))
                .supplier(supplierFromDto(costSet.supplier()))
                .user(user)
                .build();
    }

    public Position positionFromDto(Map.Entry<ru.accounterio.cost_management.dto.receipt.Position, Quantity> entry, User user) {
        return Position.builder()
                .quantity(entry.getValue().value())
                .price(entry.getKey().price())
                .item(
                        Item.builder()
                                .name(entry.getKey().name())
                                .category(categoryFromDto(entry.getKey().category(), user))
                                .build()
                )
                .build();
    }

    public Category categoryFromDto(ru.accounterio.cost_management.dto.receipt.Category category, User user) {
        return budgetService.getCategoryByUserIdAndName(user.getId(), category.name()).orElse(null);
    }

    public Supplier supplierFromDto(ru.accounterio.cost_management.dto.receipt.Supplier supplier) {
        return budgetService.getSupplierByName(supplier.name()).orElse(null);
    }
}