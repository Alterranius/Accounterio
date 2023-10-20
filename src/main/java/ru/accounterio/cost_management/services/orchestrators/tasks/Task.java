package ru.accounterio.cost_management.services.orchestrators.tasks;

public interface Task<I> {
    String command();
    I input();
}