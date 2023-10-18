package ru.accounterio.telegram_bot.tele_core.bot;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.Instant;

@Service
public class ReceiptBot extends TelegramLongPollingBot {
    private final Logger logger = LoggerFactory.getLogger(ReceiptBot.class);
    private final String USERNAME = "accounterio_receipt_bot";
    public static final String START = "/start";
    public static final String NEW = "/new";
    public static final String CONSULT =  "/consult";
    public static final String ADVICE =  "/advice";

    public ReceiptBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) return;
        var message = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();
        var userName = update.getMessage().getChat().getUserName();
        switch (message) {
            case START -> startCommand(chatId, userName);
            case NEW -> newCommand(chatId);
            case CONSULT -> consultCommand(chatId);
            case ADVICE -> adviceCommand(chatId);
            default -> unknownCommand(chatId);
        }
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    private void sendMessage(Long chatId, String text) {
        var message = new SendMessage(String.valueOf(chatId), text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Ошибка отправки сообщения {}", Instant.now().toString());
        }
    }

    private void startCommand(Long chatId, String userName) {
        sendMessage(chatId, String.format(ReceiptBotShares.START_MESSAGE, userName));
    }

    private void newCommand(Long chatId) {
        sendMessage(chatId, ReceiptBotShares.UNKNOWN_MESSAGE);
    }

    private void consultCommand(Long chatId) {
        sendMessage(chatId, ReceiptBotShares.UNKNOWN_MESSAGE);
    }

    private void adviceCommand(Long chatId) {
        sendMessage(chatId, ReceiptBotShares.UNKNOWN_MESSAGE);
    }

    private void unknownCommand(Long chatId) {
        sendMessage(chatId, ReceiptBotShares.UNKNOWN_MESSAGE);
    }
}