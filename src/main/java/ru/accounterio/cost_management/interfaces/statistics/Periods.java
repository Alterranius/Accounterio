package ru.accounterio.cost_management.interfaces.statistics;

public enum Periods {
    DAILY,
    WEEKLY,
    MONTHLY;

    public static Periods getByName(String name) {
        return switch (name) {
            case "weekly" -> WEEKLY;
            case "monthly" -> MONTHLY;
            default -> DAILY;
        };
    }
}
