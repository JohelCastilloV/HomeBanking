package com.intelligo.banking.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelligo.banking.model.ATM;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ATMApi {


    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public ATMApi(ObjectMapper objectMapper, @Qualifier("ATM") RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @SneakyThrows
    @Cacheable("atms")
    public List<ATM> findAll(){
        final String body = restTemplate.getForEntity("locator/atms/", String.class).getBody();
        if (body == null) return Collections.emptyList();
        final ATM[] atms = objectMapper.readValue(body.substring(body.indexOf('[')), ATM[].class);
        return Arrays.asList(atms);
    }

}
