package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.ClientRequest;
import com.mariamacovei.exchange.dto.ExchangeCurrencyResponse;
import com.mariamacovei.exchange.entity.Client;
import com.mariamacovei.exchange.service.ClientService;
import com.mariamacovei.exchange.service.ExchangeCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ExchangeCurrencyService exchangeCurrencyService;

    @PostMapping
    public ResponseEntity<String> addClient(@Valid @RequestBody ClientRequest clientRequest) {
        Long id = clientService.addClient(clientRequest);
        return new ResponseEntity<>("Client with id " + id + " was added", OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id) {
        Client client = clientService.findClient(id);
        return new ResponseEntity<>(client, OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateClient(@PathVariable Long id,
                                             @RequestBody @Valid ClientRequest request) {
        Long clientId = clientService.updateClient(id, request);
        return new ResponseEntity<>(clientId, OK);
    }

    @GetMapping("/{id}/currency")
    public ResponseEntity<List<ExchangeCurrencyResponse>> findCurrencyExchangeByClientId(@PathVariable Long id) {
        List<ExchangeCurrencyResponse> currencyExchange = exchangeCurrencyService.findCurrencyExchangeByClientId(id);
        return new ResponseEntity<>(currencyExchange, OK);
    }



}
