package ru.accounterio.cost_management.services.orchestrators.tasks;

import ru.accounterio.cost_management.dto.Situation;

import java.io.Serializable;

public record ConsultUserTask(Situation input, String command) implements Serializable, Task<Situation> {
}
