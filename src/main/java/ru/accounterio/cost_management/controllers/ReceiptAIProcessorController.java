package ru.accounterio.cost_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.accounterio.cost_management.interfaces.orchestrators.BotOrchestrator;
import ru.accounterio.cost_management.interfaces.orchestrators.ConsultingOrchestrator;
import ru.accounterio.cost_management.interfaces.orchestrators.OrchestrationException;
import ru.accounterio.cost_management.interfaces.orchestrators.ReceiptAIProcessorOrchestrator;

@RestController
@RequestMapping("/api/v1/processor")
@Tag(name = "ReceipAI internal API", description = "Used as ReceiptAI gates")
public class ReceiptAIProcessorController {
    private final ConsultingOrchestrator consultingOrchestrator;
    private final ReceiptAIProcessorOrchestrator processorOrchestrator;
    private final BotOrchestrator botOrchestrator;

    @Autowired
    public ReceiptAIProcessorController(ConsultingOrchestrator consultingOrchestrator, ReceiptAIProcessorOrchestrator processorOrchestrator, BotOrchestrator botOrchestrator) {
        this.consultingOrchestrator = consultingOrchestrator;
        this.processorOrchestrator = processorOrchestrator;
        this.botOrchestrator = botOrchestrator;
    }

    @Operation(summary = "Notify about Receipt processing status")
    @GetMapping("/receipt/{user_id}")
    public ResponseEntity<HttpStatus> getReceipt(@PathVariable("user_id") Long id) {
        try {
            botOrchestrator.orchestrateEndReceiptBP(id);
            processorOrchestrator.orchestrateEndReceiptBP(id);
            return ResponseEntity.ok().body(HttpStatus.OK);
        } catch (OrchestrationException ignored) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Notify about Consultation processing status")
    @GetMapping("/consult/{user_id}")
    public ResponseEntity<HttpStatus> getConsulting(@PathVariable("user_id") Long id) {
        try {
            botOrchestrator.orchestrateEndConsultBP(id);
            consultingOrchestrator.orchestrateEndConsultBP(id);
            return ResponseEntity.ok().body(HttpStatus.OK);
        } catch (OrchestrationException ignored) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Notify about Advice processing status")
    @GetMapping("/advice/{user_id}")
    public ResponseEntity<HttpStatus> getAdvice(@PathVariable("user_id") Long id) {
        try {
            botOrchestrator.orchestrateEndAdviceBP(id);
            consultingOrchestrator.orchestrateEndAdviceBP(id);
            return ResponseEntity.ok().body(HttpStatus.OK);
        } catch (OrchestrationException ignored) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
