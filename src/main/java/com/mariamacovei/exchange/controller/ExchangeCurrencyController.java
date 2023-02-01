package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.ExchangeCurrencyRequest;
import com.mariamacovei.exchange.dto.ExchangeCurrencyResponse;
import com.mariamacovei.exchange.service.ExchangeCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class ExchangeCurrencyController {

    private final ExchangeCurrencyService exchangeCurrencyService;

    @PostMapping
    public ResponseEntity<String> addExchangeCurrency(@RequestBody ExchangeCurrencyRequest request) {
        Long id = exchangeCurrencyService.addExchangeCurrency(request);
        return new ResponseEntity<>("Exchange currency with id: " + id + " was created successfully", CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ExchangeCurrencyResponse>> findCurrencyExchangeByClientId(@PathVariable Long id) {
        List<ExchangeCurrencyResponse> currencyExchange = exchangeCurrencyService.findCurrencyExchangeByClientId(id);
        return new ResponseEntity<>(currencyExchange, OK);
    }
}
