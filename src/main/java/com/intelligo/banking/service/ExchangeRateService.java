package com.intelligo.banking.service;

import com.intelligo.banking.connector.CurrencyLayerApi;
import com.intelligo.banking.model.CurrencyConversion;
import com.intelligo.banking.model.CurrencyLayout;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final CurrencyLayerApi currencyLayerApi;


    public Optional<CurrencyConversion> convert(String from, String to, BigDecimal amount) {
        final CurrencyLayout currencyLayout = currencyLayerApi.findAll();
        if (currencyLayout != null) {
            final BigDecimal exchangeRate = currencyLayout.getQuotes().get(from + to);
            if(exchangeRate == null) return Optional.empty();
            return Optional.of(CurrencyConversion.builder()
                    .currencyFrom(from)
                    .currencyTo(to)
                    .amount(amount)
                    .exchangeRate(exchangeRate)
                    .totalCalculatedAmount(amount.multiply(exchangeRate)).build());
        } else {
            return Optional.empty();
        }
    }
}
