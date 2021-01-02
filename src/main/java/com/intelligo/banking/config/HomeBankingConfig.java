package com.intelligo.banking.config;

import com.intelligo.banking.connector.ATMProperties;
import com.intelligo.banking.connector.CurrencyLayerProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;

@Configuration
public class HomeBankingConfig {

    @Bean("ExchangeRate")
    public RestTemplate restTemplate(RestTemplateBuilder builder, CurrencyLayerProperties properties) {
        return builder
                .uriTemplateHandler(new DefaultUriBuilderFactory(properties.getBaseUrl()))
                .setConnectTimeout(Duration.ofMillis(properties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeout()))
                .build();
    }

    @Bean("ATM")
    public RestTemplate restTemplateFor(RestTemplateBuilder builder, ATMProperties properties) {
        return builder
                .uriTemplateHandler(new DefaultUriBuilderFactory(properties.getBaseUrl()))
                .setConnectTimeout(Duration.ofMillis(properties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeout()))
                .build();
    }
}
