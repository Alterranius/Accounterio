package ru.accounterio.cost_management.services.orchestrators.tasks;

import java.io.Serializable;

public interface Task<I> extends Serializable {
    String command();
    I input();
}