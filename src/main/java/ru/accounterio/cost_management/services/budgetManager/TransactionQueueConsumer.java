package ru.accounterio.cost_management.services.budgetManager;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.accounterio.cost_management.dto.receipt.CostSet;

@Component
public class TransactionQueueConsumer {
    @RabbitListener(queues = {"transaction-queue"})
    public void consume(CostSet costSet) {

    }
}
