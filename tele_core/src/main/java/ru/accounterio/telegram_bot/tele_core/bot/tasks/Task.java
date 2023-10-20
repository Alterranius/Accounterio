package ru.accounterio.telegram_bot.tele_core.bot.tasks;

import ru.accounterio.telegram_bot.tele_core.dto.Advice;
import ru.accounterio.telegram_bot.tele_core.dto.Callback;
import ru.accounterio.telegram_bot.tele_core.dto.Consultation;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

public sealed interface Task extends Serializable {
    String SUCCESS_CONSULTATION_COMMAND = "consult(user)";
    String SUCCESS_ADVICE_COMMAND = "advice(user)";
    String SUCCESS_PROCESSING_COMMAND = "receipt_processing_success(user)";

    default Optional<Map.Entry<String, String>> extract() {
        if (this instanceof AdviceTask t && t.command().equals(SUCCESS_ADVICE_COMMAND)) {
            return Optional.of(Map.entry(t.input().userId().toString(), t.input().value()));
        } else if (this instanceof ConsultTask t && t.command().equals(SUCCESS_CONSULTATION_COMMAND)) {
            return Optional.of(Map.entry(t.input().userId().toString(), t.input().value()));
        } else if (this instanceof CallbackTask t && t.command().equals(SUCCESS_PROCESSING_COMMAND)) {
            return Optional.of(Map.entry(t.input().userId().toString(), t.input().value()));
        }
        return Optional.empty();
    }
}

record AdviceTask(Advice input, String command) implements Task, Serializable {
}

record ConsultTask(Consultation input, String command) implements Task, Serializable {
}

record CallbackTask(Callback input, String command) implements Task, Serializable {
}
