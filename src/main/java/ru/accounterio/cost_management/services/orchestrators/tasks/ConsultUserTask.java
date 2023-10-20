package ru.accounterio.cost_management.services.orchestrators.tasks;

import ru.accounterio.cost_management.dto.Consultation;

import java.io.Serializable;

public record ConsultUserTask(Consultation input, String command) implements Serializable, Task<Consultation> {
}
