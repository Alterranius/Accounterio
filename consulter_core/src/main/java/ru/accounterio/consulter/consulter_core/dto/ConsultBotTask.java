package ru.accounterio.consulter.consulter_core.dto;

import java.io.Serializable;

public record ConsultBotTask(Consultation input, String command) implements Serializable {
}
