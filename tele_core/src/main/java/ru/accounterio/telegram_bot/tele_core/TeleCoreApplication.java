package ru.accounterio.telegram_bot.tele_core;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeleCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeleCoreApplication.class, args);
	}

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient();
	}
}
