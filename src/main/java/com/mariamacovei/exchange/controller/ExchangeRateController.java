package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.ExchangeRateRequest;
import com.mariamacovei.exchange.dto.ExchangeRateResponse;
import com.mariamacovei.exchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    @GetMapping
    public ResponseEntity<ExchangeRateResponse> getExchangeRate(@RequestParam("currencyCode") String currencyCode){
        ExchangeRateResponse exchangeRate = exchangeRateService.getExchangeRate(currencyCode);
        return new ResponseEntity<>(exchangeRate, OK);
    }
}
