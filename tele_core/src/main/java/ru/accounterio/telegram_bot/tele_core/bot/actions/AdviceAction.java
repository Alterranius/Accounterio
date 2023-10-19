package ru.accounterio.telegram_bot.tele_core.bot.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.accounterio.telegram_bot.tele_core.bot.AccounterioClient;
import ru.accounterio.telegram_bot.tele_core.bot.interfaces.Action;

@Component
public class AdviceAction implements Action {
    private final AccounterioClient client;

    @Autowired
    public AdviceAction(AccounterioClient client) {
        this.client = client;
    }

    @Override
    public BotApiMethod handle(Update update) {
        return new SendMessage(
                update.getMessage().getChatId().toString(),
                handleServerCode(client.askAdviceProcessing(update.getMessage().getChatId()))
        );
    }

    @Override
    public BotApiMethod callback(Update update) {
        return handle(update);
    }
}