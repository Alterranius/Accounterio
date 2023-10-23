package ru.accounterio.telegram_bot.tele_core.bot.actions;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.accounterio.telegram_bot.tele_core.bot.CommandSet;
import ru.accounterio.telegram_bot.tele_core.bot.ReceiptBotShares;
import ru.accounterio.telegram_bot.tele_core.bot.interfaces.Action;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartAction implements Action {
    private static final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

    static {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(List.of(
                InlineKeyboardButton.builder().text("Новый чек").callbackData(CommandSet.NEW).build()));
        rowList.add(List.of(
                InlineKeyboardButton.builder().text("Консультация").callbackData(CommandSet.CONSULT).build(),
                InlineKeyboardButton.builder().text("Совет").callbackData(CommandSet.ADVICE).build()));
        inlineKeyboardMarkup.setKeyboard(rowList);
    }

    @Override
    public BotApiMethod handle(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var userName = update.getMessage().getChat().getUserName();
        return SendMessage.builder().chatId(chatId).text(String.format(ReceiptBotShares.START_MESSAGE, userName)).replyMarkup(inlineKeyboardMarkup).build();
    }

    @Override
    public BotApiMethod callback(Update update) {
        return handle(update);
    }
}
