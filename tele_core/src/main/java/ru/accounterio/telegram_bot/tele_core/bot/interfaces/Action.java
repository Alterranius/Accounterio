package ru.accounterio.telegram_bot.tele_core.bot.interfaces;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBotShares;

import java.time.Instant;

public interface Action {
    BotApiMethod handle(Update update);
    BotApiMethod callback(Update update);
    default String handleServerCode(int code) {
        return switch (code) {
            case 200 -> ReceiptBotShares.PROCESSING_MESSAGE;
            case 500 -> ReceiptBotShares.SERVICE_ERROR_MESSAGE;
            default -> ReceiptBotShares.SERVICE_ERROR_MESSAGE;
        };
    }
}
