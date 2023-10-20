package ru.accounterio.telegram_bot.tele_core.bot.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.accounterio.telegram_bot.tele_core.bot.AccounterioClient;
import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBotShares;
import ru.accounterio.telegram_bot.tele_core.bot.exceptions.CoreServiceException;
import ru.accounterio.telegram_bot.tele_core.bot.exceptions.DownloadException;
import ru.accounterio.telegram_bot.tele_core.bot.interfaces.Action;
import ru.accounterio.telegram_bot.tele_core.bot.util.MessageHandler;

@Component
public class PhotoAction implements Action {
    private final AccounterioClient client;
    private final MessageHandler messageHandler;

    @Autowired
    public PhotoAction(AccounterioClient client, MessageHandler messageHandler) {
        this.client = client;
        this.messageHandler = messageHandler;
    }

    @Override
    public BotApiMethod handle(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(), ReceiptBotShares.ASK_IMAGE_MESSAGE);
    }

    @Override
    public BotApiMethod callback(Update update) {
        if (!update.getMessage().hasPhoto())
            return new SendMessage(update.getMessage().getChatId().toString(), ReceiptBotShares.WRONG_PHOTO);

        String answer = null;
        try {
            answer = handleServerCode(client.askReceiptProcessing(messageHandler.handlePhoto(update.getMessage())));
        } catch (CoreServiceException | DownloadException e) {
            answer = e.getMessage();
        }
        return new SendMessage(update.getMessage().getChatId().toString(), answer);
    }
}
