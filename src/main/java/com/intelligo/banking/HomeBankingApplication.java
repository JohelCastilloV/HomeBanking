package com.intelligo.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class HomeBankingApplication {


    public static void main(String[] args) {
        SpringApplication.run(HomeBankingApplication.class, args);
    }

}
