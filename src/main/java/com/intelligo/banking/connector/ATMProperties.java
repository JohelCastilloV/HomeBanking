package com.intelligo.banking.connector;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "atms")
@Getter
@Setter
public class ATMProperties {
    private String baseUrl;
    private Long readTimeout;
    private Long connectTimeout;
    private Long writeTimeout;
}
