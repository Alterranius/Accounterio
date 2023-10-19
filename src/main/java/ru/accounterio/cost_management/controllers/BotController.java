package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.dto.ReceiptImage;
import ru.accounterio.cost_management.services.orchestrators.BotOrchestrator;

@RestController
@RequestMapping("/api/v1/bot")
@Tag(name = "Telegram Bot internal API", description = "Used as TelegramBot gates")
public class BotController {
    private final BotOrchestrator botOrchestrator;

    @Autowired
    public BotController(BotOrchestrator botOrchestrator) {
        this.botOrchestrator = botOrchestrator;
    }

    @Operation(summary = "Ask for Receipt processing")
    @PostMapping("/receipt/new")
    public ResponseEntity<HttpStatus> addReceipt(@RequestBody ReceiptImage receiptImage) {
        // TODO: 19.10.2023 rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @Operation(summary = "Ask for Consultation processing")
    @GetMapping("/consult/{user_id}")
    public ResponseEntity<HttpStatus> getConsulting(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @Operation(summary = "Ask for Advice processing")
    @GetMapping("/advice/{user_id}")
    public ResponseEntity<HttpStatus> getAdvice(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
