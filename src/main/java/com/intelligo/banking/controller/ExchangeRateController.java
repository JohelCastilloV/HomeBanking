package com.intelligo.banking.controller;

import com.intelligo.banking.model.CurrencyConversion;
import com.intelligo.banking.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;
    @Operation(summary = "Convert money from one currency to another")
    @GetMapping("convert")
    @CrossOrigin
    public ResponseEntity<CurrencyConversion> convertMoney(String currencyFrom, String currencyTo, @NotNull BigDecimal amount) {
        return exchangeRateService.convert(currencyFrom, currencyTo, amount)
                .map(currencyConversion -> ResponseEntity.ok().body(currencyConversion))
                .orElse(ResponseEntity.badRequest().build());
    }
}
