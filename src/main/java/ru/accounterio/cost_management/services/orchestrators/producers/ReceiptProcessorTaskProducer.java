package ru.accounterio.cost_management.services.orchestrators.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.cost_management.config.RabbitConfig;
import ru.accounterio.cost_management.services.orchestrators.tasks.ReceiptProcessTask;
import ru.accounterio.cost_management.interfaces.RabbitProducer;

@Component
public class ReceiptProcessorTaskProducer extends RabbitProducer<ReceiptProcessTask> {

    @Autowired
    public ReceiptProcessorTaskProducer(RabbitTemplate rabbitTemplate) {
        super(RabbitConfig.receiptAITasksRoutingKey, rabbitTemplate);
    }
}
