package ru.accounterio.telegram_bot.tele_core.bot.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.accounterio.telegram_bot.tele_core.bot.AccounterioClient;
import ru.accounterio.telegram_bot.tele_core.bot.exceptions.CoreServiceException;
import ru.accounterio.telegram_bot.tele_core.bot.interfaces.Action;

@Component
public class ConsultAction implements Action {
    private final AccounterioClient client;

    @Autowired
    public ConsultAction(AccounterioClient client) {
        this.client = client;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String answer = null;
        try {
            answer = handleServerCode(client.askConsultProcessing(update.getMessage().getChatId()));
        } catch (CoreServiceException e) {
            answer = e.getMessage();
        }
        return new SendMessage(update.getMessage().getChatId().toString(), answer);
    }

    @Override
    public BotApiMethod callback(Update update) {
        return handle(update);
    }
}
