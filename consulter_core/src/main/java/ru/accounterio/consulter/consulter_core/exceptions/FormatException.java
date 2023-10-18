package ru.accounterio.consulter.consulter_core.exceptions;

import java.io.IOException;

public class FormatException extends IOException {
    private static final String MESSAGE = "Ошибка форматирования данных:(";
    public FormatException() {
        super(MESSAGE);
    }
}
