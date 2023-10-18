package ru.accounterio.telegram_bot.tele_core.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReceiptBotShares {
    public static final String START_MESSAGE = """
            Привет, %s!
            
            Я бот Accounter.io
            В спектр моих возможностей входит:
            
            /new - обработать изображение чека
            /consult - получить консультацию по текущему финансовому положению
            /advice - получить совет по оптимизации затрат
            /help - инструкция пользования
            """;
    public static final String UNKNOWN_MESSAGE = """
            Извините, но такой команды я не поддерживаю...
            """;
}
