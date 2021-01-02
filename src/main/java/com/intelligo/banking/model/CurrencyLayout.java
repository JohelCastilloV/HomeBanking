package com.intelligo.banking.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class CurrencyLayout {
    Map<String, BigDecimal> quotes;
}
