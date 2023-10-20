package ru.accounterio.cost_management.services.orchestrators.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.cost_management.config.RabbitConfig;
import ru.accounterio.cost_management.interfaces.RabbitProducer;
import ru.accounterio.cost_management.services.orchestrators.tasks.AdviceUserTask;

@Component
public class BotAdviceTaskProducer extends RabbitProducer<AdviceUserTask> {
    @Autowired
    public BotAdviceTaskProducer(RabbitTemplate rabbitTemplate) {
        super(RabbitConfig.botTasksRoutingKey, rabbitTemplate);
    }
}
