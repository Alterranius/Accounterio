package ru.accounterio.cost_management;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.accounterio.cost_management.config.AccounterioCoreTestContainers;

@SpringBootTest(classes = {AccounterioCoreTestContainers.class})
@AutoConfigureMockMvc
public class AccounterioCoreApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void bot_receiptTaskDelegation_correct() {

    }

    @Test
    public void bot_consultTaskDelegation_correct() {

    }

}
