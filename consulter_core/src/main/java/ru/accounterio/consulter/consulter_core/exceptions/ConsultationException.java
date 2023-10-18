package ru.accounterio.consulter.consulter_core.exceptions;

import java.io.IOException;

public class ConsultationException extends IOException {
    private static final String MESSAGE = "Ошибка анализа данных пользователя:(";
    public ConsultationException() {
        super(MESSAGE);
    }
}
