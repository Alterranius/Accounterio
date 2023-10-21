package ru.accounterio.consulter.consulter_core.services.cost_consulter;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccounterioCoreClient {
    @Value("${accounterio.url}")
    private String url;

    private final String consultationUrl = "/consult";
    private final String adviceUrl = "/advice";
    private final Client client = ClientBuilder.newClient();

    public void notifyOnConsultation(Long userId) {
        client.target(url + consultationUrl)
                .path(userId.toString())
                .request()
                .get();
    }

    public void notifyOnAdvice(Long userId) {
        client.target(url + adviceUrl)
                .path(userId.toString())
                .request()
                .get();
    }

}
