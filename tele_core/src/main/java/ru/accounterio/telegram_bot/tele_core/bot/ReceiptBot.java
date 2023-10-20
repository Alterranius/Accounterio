package ru.accounterio.telegram_bot.tele_core.bot;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.accounterio.telegram_bot.tele_core.bot.actions.AdviceAction;
import ru.accounterio.telegram_bot.tele_core.bot.actions.ConsultAction;
import ru.accounterio.telegram_bot.tele_core.bot.actions.PhotoAction;
import ru.accounterio.telegram_bot.tele_core.bot.actions.StartAction;
import ru.accounterio.telegram_bot.tele_core.bot.util.RuleSet;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReceiptBot extends TelegramLongPollingBot {
    private final Logger logger = LoggerFactory.getLogger(ReceiptBot.class);
    private final String USERNAME = "accounterio_receipt_bot";
    private final RuleSet ruleSet;
    private final Map<String, String> bindingBy = new ConcurrentHashMap<>();

    @Autowired
    public ReceiptBot(@Value("${bot.token}") String botToken, StartAction startAction, ConsultAction consultAction, PhotoAction photoAction, AdviceAction adviceAction) {
        super(botToken);
        ruleSet = new RuleSet(Map.of(CommandSet.START, startAction, CommandSet.NEW, photoAction, CommandSet.CONSULT, consultAction, CommandSet.ADVICE, adviceAction));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) return;
        var key = update.getMessage().getText();
        var chatId = update.getMessage().getChatId().toString();
        if (ruleSet.actions().containsKey(key)) {
            var method = ruleSet.actions().get(key).handle(update);
            bindingBy.put(chatId, key);
            send(method);
        } else if (bindingBy.containsKey(chatId)) {
            var method = ruleSet.actions().get(bindingBy.get(chatId)).callback(update);
            send(method);
        }
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    private void send(BotApiMethod method) {
        try {
            execute(method);
        } catch (TelegramApiException e) {
            logger.error("Ошибка отправки сообщения {}", Instant.now().toString());
        }
    }

    @RabbitListener(queues = {"bot-task-queue"})
    public void consume() {

    }
}