package ru.accounterio.cost_management.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.accounterio.cost_management.dto.ReceiptImage;

@RestController
@RequestMapping("/api/v1/bot")
public class BotController {
    @PostMapping("/receipt/new")
    public ResponseEntity<HttpStatus> addReceipt(@RequestBody ReceiptImage receiptImage) {
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
