package ru.accounterio.receiptai.receiptai_processor.interfaces.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public abstract class RabbitProducer<T> {
    protected final String exchange = "accouterio-core-exchange";
    protected final String routingKey;
    private final RabbitTemplate rabbitTemplate;

    protected RabbitProducer(String routingKey, RabbitTemplate rabbitTemplate) {
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(T message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
