package ru.accounterio.telegram_bot.tele_core.bot.actions;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBotShares;
import ru.accounterio.telegram_bot.tele_core.bot.interfaces.Action;

@Component
public class StartAction implements Action {
    @Override
    public BotApiMethod handle(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var userName = update.getMessage().getChat().getUserName();
        return new SendMessage(chatId, String.format(ReceiptBotShares.START_MESSAGE, userName));
    }

    @Override
    public BotApiMethod callback(Update update) {
        return handle(update);
    }
}
