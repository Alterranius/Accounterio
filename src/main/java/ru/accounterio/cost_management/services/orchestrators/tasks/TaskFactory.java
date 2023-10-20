package ru.accounterio.cost_management.services.orchestrators.tasks;

import ru.accounterio.cost_management.dto.Advice;
import ru.accounterio.cost_management.dto.Consultation;
import ru.accounterio.cost_management.dto.ReceiptImage;

public class TaskFactory {
    private Command command;

    public TaskFactory withCommand(Command command) {
        this.command = command;
        return this;
    }

    public ReceiptProcessTask createReceiptProcessTask(ReceiptImage receiptImage) {
        return new ReceiptProcessTask(receiptImage, command.get());
    }

    public ConsultUserTask createConsultUserTask(Consultation consultation) {
        return new ConsultUserTask(consultation, command.get());
    }

    public AdviceUserTask createAdviceUserTask(Advice advice) {
        return new AdviceUserTask(advice, command.get());
    }
}
