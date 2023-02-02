package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.ExchangeCurrencyRequest;
import com.mariamacovei.exchange.service.ExchangeCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

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

}
