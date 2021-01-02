package com.intelligo.banking.connector;

import com.intelligo.banking.model.CurrencyLayout;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyLayerApi {


    private final CurrencyLayerProperties currencyLayerProperties;
    private final RestTemplate restTemplate;

    public CurrencyLayerApi(CurrencyLayerProperties currencyLayerProperties, @Qualifier("ExchangeRate") RestTemplate restTemplate) {
        this.currencyLayerProperties = currencyLayerProperties;
        this.restTemplate = restTemplate;
    }

    @Cacheable("currency")
    public CurrencyLayout findAll(){
        return restTemplate.getForObject("live?access_key={access_key}",
                CurrencyLayout.class, currencyLayerProperties.getAccessKey());
    }

}
