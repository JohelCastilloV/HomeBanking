package com.intelligo.banking.connector;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "currency-layer")
@Getter
@Setter
public class CurrencyLayerProperties {
    private String baseUrl;
    private Long readTimeout;
    private Long connectTimeout;
    private Long writeTimeout;
    private String accessKey;
}
