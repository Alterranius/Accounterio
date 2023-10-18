package ru.accounterio.cost_management.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/processor")
public class ReceiptAIProcessorController {
    @GetMapping("/receipt/{user_id}")
    public ResponseEntity<HttpStatus> getReceipt(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/consult/{user_id}")
    public ResponseEntity<HttpStatus> getConsulting(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/advice/{user_id}")
    public ResponseEntity<HttpStatus> getAdvice(@PathVariable("user_id") Long id) {
        // TODO: 19.10.2023 rpc call
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
