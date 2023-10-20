package ru.accounterio.telegram_bot.tele_core.bot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.accounterio.telegram_bot.tele_core.bot.exceptions.DownloadException;
import ru.accounterio.telegram_bot.tele_core.dto.ReceiptImage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

@Component
public class MessageHandler {
    @Value("${bot.uri}")
    private String fileStorageUri;
    @Value("${bot.token}")
    private String botToken;
    public ReceiptImage handlePhoto(Message message) throws DownloadException {
        return new ReceiptImage(
                message.getChatId(),
                Instant.now(),
                download(message.getPhoto().get(0).getFilePath())
        );
    }

    private byte[] download(String filePath) throws DownloadException {
        URL url = null;
        try {
            url = new URL(
                    fileStorageUri
                            .replace("{token}", botToken)
                            .replace("{filePath}", filePath));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (BufferedInputStream is = new BufferedInputStream(url.openStream())) {
            return is.readAllBytes();
        } catch (IOException e) {
            throw new DownloadException(e);
        }
    }
}
