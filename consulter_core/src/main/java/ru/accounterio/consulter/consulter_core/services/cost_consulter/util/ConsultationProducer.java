package ru.accounterio.consulter.consulter_core.services.cost_consulter.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.consulter.consulter_core.dto.ConsultBotTask;
import ru.accounterio.consulter.consulter_core.interfaces.RabbitProducer;

@Component
public class ConsultationProducer extends RabbitProducer<ConsultBotTask> {
    @Autowired
    public ConsultationProducer(RabbitTemplate rabbitTemplate) {
        super("bot-task-queue", rabbitTemplate);
    }
}
