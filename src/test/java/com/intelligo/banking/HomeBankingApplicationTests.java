package com.intelligo.banking;

import com.intelligo.banking.service.ATMService;
import com.intelligo.banking.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

@SpringBootTest
class HomeBankingApplicationTests {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Autowired
    ATMService atmService;
    @Test
    void findATMs() {
        Assertions.assertFalse(CollectionUtils.isEmpty(atmService.findAll()));
    }

}
