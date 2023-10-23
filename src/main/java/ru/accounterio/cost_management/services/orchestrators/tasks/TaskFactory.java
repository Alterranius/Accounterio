package ru.accounterio.cost_management.services.orchestrators.tasks;

import ru.accounterio.cost_management.dto.ReceiptImage;
import ru.accounterio.cost_management.dto.Situation;

public class TaskFactory {
    private Command command;

    public TaskFactory withCommand(Command command) {
        this.command = command;
        return this;
    }

    public ReceiptProcessTask createReceiptProcessTask(ReceiptImage receiptImage) {
        return new ReceiptProcessTask(receiptImage, command.get());
    }

    public ConsultUserTask createConsultUserTask(Situation situation) {
        return new ConsultUserTask(situation, command.get());
    }

    public AdviceUserTask createAdviceUserTask(Situation situation) {
        return new AdviceUserTask(situation, command.get());
    }
}
