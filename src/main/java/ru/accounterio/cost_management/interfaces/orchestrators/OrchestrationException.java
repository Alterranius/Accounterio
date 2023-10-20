package ru.accounterio.cost_management.interfaces.orchestrators;

import java.io.IOException;

public class OrchestrationException extends IOException {
    public static final String MESSAGE = "Ошибка центрального сервиса";

    public OrchestrationException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
