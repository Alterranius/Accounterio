package ru.accounterio.receiptai.receiptai_processor.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.accounterio.receiptai.receiptai_processor.domains.CostSet;
import ru.accounterio.receiptai.receiptai_processor.interfaces.util.RabbitProducer;

@Component
public class CostSetProducer extends RabbitProducer<CostSet> {

    @Autowired
    public CostSetProducer(RabbitTemplate rabbitTemplate) {
        super("costmanagement.tasks.1.0.costchannel", rabbitTemplate);
    }
}
