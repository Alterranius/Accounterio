package ru.accounterio.telegram_bot.tele_core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBot;

@Configuration
public class ReceiptBotConfiguration {
    @Bean
    public TelegramBotsApi telegramBotsApi(ReceiptBot receiptBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(receiptBot);
        return api;
    }
}
