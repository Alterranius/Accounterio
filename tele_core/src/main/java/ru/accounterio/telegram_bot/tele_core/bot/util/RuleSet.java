package ru.accounterio.telegram_bot.tele_core.bot.util;

import ru.accounterio.telegram_bot.tele_core.bot.interfaces.Action;

import java.util.Map;

public record RuleSet(Map<String, Action> actions) {
}
