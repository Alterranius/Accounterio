package ru.accounterio.consulter.consulter_core.dto;

import java.io.Serializable;

public record AdviceBotTask(Advice input, String command) implements Serializable {
}
