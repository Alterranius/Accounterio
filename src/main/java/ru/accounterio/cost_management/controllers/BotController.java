package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.dto.ReceiptImage;
import ru.accounterio.cost_management.interfaces.orchestrators.ConsultingOrchestrator;
import ru.accounterio.cost_management.interfaces.orchestrators.OrchestrationException;
import ru.accounterio.cost_management.interfaces.orchestrators.ReceiptAIProcessorOrchestrator;

@RestController
@RequestMapping("/api/v1/bot")
@Tag(name = "Telegram Bot internal API", description = "Used as TelegramBot gates")
public class BotController {
    private final ConsultingOrchestrator consultingOrchestrator;
    private final ReceiptAIProcessorOrchestrator receiptProcessorOrchestrator;

    @Autowired
    public BotController(ConsultingOrchestrator consultingOrchestrator, ReceiptAIProcessorOrchestrator receiptProcessorOrchestrator) {
        this.consultingOrchestrator = consultingOrchestrator;
        this.receiptProcessorOrchestrator = receiptProcessorOrchestrator;
    }

    @Operation(summary = "Ask for Receipt processing")
    @PostMapping("/receipt/new")
    public ResponseEntity<String> addReceipt(@RequestBody ReceiptImage receiptImage) {
        try {
            receiptProcessorOrchestrator.orchestrateAddReceiptBP(receiptImage);
            return ResponseEntity.ok().body(HttpStatus.OK.toString());
        } catch (OrchestrationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Ask for Consultation processing")
    @GetMapping("/consult/{user_id}")
    public ResponseEntity<String> getConsulting(@PathVariable("user_id") Long id) {
        try {
            consultingOrchestrator.orchestrateConsultBP(id);
            return ResponseEntity.ok().body(HttpStatus.OK.toString());
        } catch (OrchestrationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Ask for Advice processing")
    @GetMapping("/advice/{user_id}")
    public ResponseEntity<String> getAdvice(@PathVariable("user_id") Long id) {
        try {
            consultingOrchestrator.orchestrateAdviceBP(id);
            return ResponseEntity.ok().body(HttpStatus.OK.toString());
        } catch (OrchestrationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
