package com.intelligo.banking;


import com.intelligo.banking.connector.CurrencyLayerApi;
import com.intelligo.banking.model.CurrencyConversion;
import com.intelligo.banking.model.CurrencyLayout;
import com.intelligo.banking.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class ExchangeRateServiceTests {
    private ExchangeRateService exchangeRateService;
    private CurrencyLayerApi currencyLayerApi;


    @BeforeEach
    public void setUp() {
        currencyLayerApi = Mockito.mock(CurrencyLayerApi.class);
        exchangeRateService = new ExchangeRateService(currencyLayerApi);
    }
    @Test
    public void itShouldReturnConversionEmpty() {
        when(currencyLayerApi.findAll()).thenReturn(null);
        final Optional<CurrencyConversion> conversion = exchangeRateService.convert("PEN", "USD", BigDecimal.TEN);
        Assertions.assertTrue(conversion.isEmpty());
    }

    @Test
    public void itShouldReturnConversionEmptyWhenCurrencyCodeNotFound() {
        when(currencyLayerApi.findAll()).thenReturn(buildCurrencyLayout());
        final Optional<CurrencyConversion> conversion = exchangeRateService.convert("PEN", "USD", BigDecimal.TEN);
        Assertions.assertTrue(conversion.isEmpty());
    }
    @Test
    public void itShouldReturnConversionOk() {
        when(currencyLayerApi.findAll()).thenReturn(buildCurrencyLayout());
        final Optional<CurrencyConversion> conversion = exchangeRateService.convert("USD", "PEN", BigDecimal.TEN);
        Assertions.assertEquals(31.0,conversion.get().getTotalCalculatedAmount().doubleValue());
    }
    private CurrencyLayout buildCurrencyLayout(){
        CurrencyLayout currencyLayout = new CurrencyLayout();
        final Map<String, BigDecimal> quotes = new HashMap<>();
        quotes.put("USDPEN", BigDecimal.valueOf(3.10));
        currencyLayout.setQuotes(quotes);
        return currencyLayout;
    }
}
