package ru.accounterio.consulter.consulter_core.domains;

public class Situation extends Target {
    private Long userId;
    private String description;

    public Long getUserId() {
        return userId;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
