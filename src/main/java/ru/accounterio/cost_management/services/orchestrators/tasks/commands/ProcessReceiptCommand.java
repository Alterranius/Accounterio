package ru.accounterio.cost_management.services.orchestrators.tasks.commands;

import ru.accounterio.cost_management.services.orchestrators.tasks.Command;

public record ProcessReceiptCommand() implements Command {
    @Override
    public String get() {
        return "process(receipt)";
    }
}
