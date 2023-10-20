package ru.accounterio.telegram_bot.tele_core.bot.exceptions;

import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBotShares;

import java.io.IOException;

public class DownloadException extends IOException {
    public DownloadException(Throwable cause) {
        super(ReceiptBotShares.DOWNLOAD_ERROR_MESSAGE, cause);
    }
}
