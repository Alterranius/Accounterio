package ru.accounterio.cost_management.services.orchestrators.tasks;

import ru.accounterio.cost_management.dto.Advice;

import java.io.Serializable;

public record AdviceUserTask(Advice input, String command) implements Serializable, Task<Advice> {
}
