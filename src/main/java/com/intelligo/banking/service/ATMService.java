package com.intelligo.banking.service;


import com.intelligo.banking.connector.ATMApi;
import com.intelligo.banking.model.ATM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ATMService {

    private final ATMApi atmApi;

    public List<ATM> findAll() {
        return atmApi.findAll();
    }

}
