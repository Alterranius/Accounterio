package ru.accounterio.telegram_bot.tele_core.bot.exceptions;

import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBotShares;

import java.io.IOException;

public class CoreServiceException extends IOException {
    public CoreServiceException(Throwable cause) {
        super(ReceiptBotShares.SERVICE_ERROR_MESSAGE, cause);
    }
}
