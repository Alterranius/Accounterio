package ru.accounterio.cost_management.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.Instant;

@Schema(description = "Unhandled Receipt Image from Telegram Bot")
public record ReceiptImage(int userId, Instant stamp, byte[] image) implements Serializable {
}
