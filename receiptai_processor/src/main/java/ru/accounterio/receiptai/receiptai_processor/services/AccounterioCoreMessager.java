package ru.accounterio.receiptai.receiptai_processor.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccounterioCoreMessager {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${accounterio.url}")
    private String url;
    private final String receipt = "/receipt/%d";

    public void notifySuccessProcessing(Long userId) {
        restTemplate.getForEntity(String.format((url + receipt), userId), HttpStatus.class);
    }
}
