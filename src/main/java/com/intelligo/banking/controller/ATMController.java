package com.intelligo.banking.controller;

import com.intelligo.banking.model.ATM;
import com.intelligo.banking.service.ATMService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("atms")
@RequiredArgsConstructor
public class ATMController {

    private final ATMService atmService;
    @Operation(summary = "Find atms nearby")
    @GetMapping
    @CrossOrigin
    public List<ATM> findAll(){
        return atmService.findAll();
    }
}
