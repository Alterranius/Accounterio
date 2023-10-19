package ru.accounterio.telegram_bot.tele_core.bot;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.accounterio.telegram_bot.tele_core.dto.ReceiptImage;

import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.util.Arrays;

@Component
public class AccounterioClient {
    @Value("${accounterio.url}")
    private String url;
    private static final String ASK_RECEIPT = "/receipt/new";
    private static final String ASK_CONSULT = "/consult/%s";
    private static final String ASK_ADVICE = "/advice/%s";
    private final OkHttpClient client;

    @Autowired
    public AccounterioClient(OkHttpClient client) {
        this.client = client;
    }

    public int askReceiptProcessing(ReceiptImage receiptImage) {
        var request = new Request.Builder()
                .url(url + ASK_RECEIPT)
                .post(new FormBody.Builder()
                        .add("userId", String.valueOf(receiptImage.userId()))
                        .add("stamp", receiptImage.stamp().toString())
                        .add("image", Arrays.toString(receiptImage.image()))
                        .build())
                .build();
        try (var response = client.newCall(request).execute()) {
            return response.code();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int askConsultProcessing(Long chatId) {
        var request = new Request.Builder()
                .url(url + String.format(ASK_CONSULT, chatId))
                .build();
        try (var response = client.newCall(request).execute()) {
            return response.code();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int askAdviceProcessing(Long chatId) {
        var request = new Request.Builder()
                .url(url + String.format(ASK_ADVICE, chatId))
                .build();
        try (var response = client.newCall(request).execute()) {
            return response.code();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
