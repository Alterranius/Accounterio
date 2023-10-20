package ru.accounterio.cost_management.services.orchestrators.tasks;

import ru.accounterio.cost_management.dto.ReceiptImage;

import java.io.Serializable;

public record ReceiptProcessTask(ReceiptImage input, String command) implements Serializable, Task<ReceiptImage> {
}
