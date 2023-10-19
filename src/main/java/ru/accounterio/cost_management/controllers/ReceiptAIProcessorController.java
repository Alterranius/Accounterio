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
import ru.accounterio.cost_management.services.orchestrators.ReceiptAIProcessorOrchestrator;

@RestController
@RequestMapping("/api/v1/processor")
@Tag(name = "ReceipAI internal API", description = "Used as ReceiptAI gates")
public class ReceiptAIProcessorController {
    private final ReceiptAIProcessorOrchestrator processorOrchestrator;

    @Autowired
    public ReceiptAIProcessorController(ReceiptAIProcessorOrchestrator processorOrchestrator) {
        this.processorOrchestrator = processorOrchestrator;
    }

    @Operation(summary = "Notify about Receipt processing status")
    @GetMapping("/receipt/{user_id}")
    public ResponseEntity<HttpStatus> getReceipt(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 telegram rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @Operation(summary = "Notify about Consultation processing status")
    @GetMapping("/consult/{user_id}")
    public ResponseEntity<HttpStatus> getConsulting(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 telegram rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @Operation(summary = "Notify about Advice processing status")
    @GetMapping("/advice/{user_id}")
    public ResponseEntity<HttpStatus> getAdvice(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 telegram rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
