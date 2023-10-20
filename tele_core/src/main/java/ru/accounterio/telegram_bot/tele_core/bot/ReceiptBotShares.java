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

    public static final String WRONG_PHOTO = """
            Извините, но вы не отправили фото чека ^_^
            """;
    public static final String PROCESSING_MESSAGE = """
            Сервис обрабатывает запрос. Подождите ответа...
            """;
    public static final String SERVICE_ERROR_MESSAGE = """
            К сожалению сервис сейчас не доступен и не может обработать ваш запрос( 
            """;
    public static final String ASK_IMAGE_MESSAGE = """
            Отправьте фотографию чека
            """;
    public static final String DOWNLOAD_ERROR_MESSAGE = "Сервис не смог загрузить фотографию(";
}
