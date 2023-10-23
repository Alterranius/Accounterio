package ru.accounterio.cost_management.services.budgetManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.accounterio.cost_management.config.AccounterioCoreTestContainers;
import ru.accounterio.cost_management.domains.*;
import ru.accounterio.cost_management.dto.receipt.CostSet;
import ru.accounterio.cost_management.dto.receipt.Quantity;
import ru.accounterio.cost_management.services.userService.UserServiceSimple;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AccounterioCoreTestContainers.class})
@RunWith(MockitoJUnitRunner.class)
public class TransactionQueueConsumerTest {
    @InjectMocks
    private TransactionQueueConsumer transactionQueueConsumer;

    @Spy
    private BudgetManager budgetManager;

    @Spy
    private UserServiceSimple userServiceSimple;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void positionFromDto_returnCorrect() {
        User user = User.builder().id(0L).build();
        Category category = Category.builder().user(user).name("Fruit").build();
        Mockito.when(budgetManager.getCategoryByUserIdAndName(0L, "Fruit")).thenReturn(Optional.of(category));

        Position await = Position.builder().price(50d).quantity(5)
                .item(Item.builder()
                        .name("Apple")
                        .category(category)
                        .build())
                .build();
        Map.Entry<ru.accounterio.cost_management.dto.receipt.Position, Quantity> from = Map.entry(
                new ru.accounterio.cost_management.dto.receipt.Position("Apple", 50d,
                        new ru.accounterio.cost_management.dto.receipt.Category("Fruit")),
                new Quantity(5)
        );
        assertEquals(await, transactionQueueConsumer.positionFromDto(from, user));
    }

    @Test
    public void categoryFromDto_returnCorrect() {
        User user = User.builder().id(0L).build();
        Category await = Category.builder().name("Fruit").user(user).build();
        Mockito.when(budgetManager.getCategoryByUserIdAndName(0L, "Fruit")).thenReturn(Optional.of(await));

        assertEquals(await, transactionQueueConsumer.categoryFromDto(
                new ru.accounterio.cost_management.dto.receipt.Category("Fruit"),
                user
        ));
    }

    @Test
    public void consume_correct() {
        Mockito.when(userServiceSimple.getUser(0L)).thenReturn(Optional.of(User.builder().id(0L).transactions(new HashSet<>()).build()));
        CostSet input = new CostSet(0L,
                Map.of(
                        new ru.accounterio.cost_management.dto.receipt.Position("Apple", 50d, null), new Quantity(5),
                        new ru.accounterio.cost_management.dto.receipt.Position("Tomato", 60d, null), new Quantity(3),
                        new ru.accounterio.cost_management.dto.receipt.Position("Potato", 150d, null), new Quantity(1),
                        new ru.accounterio.cost_management.dto.receipt.Position("Pen", 20d, null), new Quantity(2)
                ),
                LocalDateTime.parse("2023-05-05T15:00:00"),
                null,
                1d);
        rabbitTemplate.convertAndSend("accouterio-core-exchange", "costmanagement.tasks.1.0.costchannel", input);

        Transaction await = Transaction.builder().value(-620d).stamp(LocalDateTime.parse("2023-05-05T15:00:00")).build();
        Transaction current = budgetManager.getTransactions(0L).transactionSet().last();

        assertEquals(await.getValue(), current.getValue());
        assertEquals(await.getStamp(), current.getStamp());
        assertNotNull(current.getPositions());
        assertFalse(current.getPositions().isEmpty());
    }
}