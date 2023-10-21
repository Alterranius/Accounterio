package ru.accounterio.cost_management.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String topicExchangeName = "accouterio-core-exchange";
    public static final String transactionQueueName = "transaction-queue";
    public static final String receiptAITasksQueueName = "receipt-task-queue";
    public static final String botTasksQueueName = "bot-task-queue";
    public static final String consultantTasksQueueName = "consultant-queue";
    public static final String transactionReceiptAIRoutingKey = "costmanagement.tasks.1.0.costchannel";
    public static final String receiptAITasksRoutingKey = "costmanagement.tasks.1.0.receiptchannel";
    public static final String botTasksRoutingKey = "costmanagement.tasks.1.0.botchannel";
    public static final String consultantTasksRoutingKey = "costmanagement.tasks.1.0.consultantchanel";

    @Bean
    Queue transactionQueue() {
        return new Queue(transactionQueueName, false);
    }

    @Bean
    Queue receiptAITasksQueue() {
        return new Queue(receiptAITasksQueueName, false);
    }

    @Bean
    Queue botTasksQueue() {
        return new Queue(botTasksQueueName, false);
    }

    @Bean
    Queue consultantTasksQueue() {
        return new Queue(consultantTasksQueueName, false);
    }

    @Bean
    TopicExchange coreExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding transactionQueueBinding(@Qualifier("transactionQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(transactionReceiptAIRoutingKey);
    }

    @Bean
    Binding receiptAITasksQueueBinding(@Qualifier("receiptAITasksQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(receiptAITasksRoutingKey);
    }

    @Bean
    Binding botTasksQueueBinding(@Qualifier("botTasksQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(botTasksRoutingKey);
    }

    @Bean
    Binding consultantTasksQueueBinding(@Qualifier("consultantTasksQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(consultantTasksRoutingKey);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
