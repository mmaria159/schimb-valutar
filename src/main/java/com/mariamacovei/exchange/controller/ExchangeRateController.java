package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.ExchangeRateRequest;
import com.mariamacovei.exchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/rates")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping
    public ResponseEntity<String> addExchangeRate(@RequestBody ExchangeRateRequest request) {
        Long id = exchangeRateService.addExchangeRate(request);
        return new ResponseEntity<>("Exchange rate with id: " + id + " was created successfully", CREATED);
    }
}
