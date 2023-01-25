package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.ClientRequest;
import com.mariamacovei.exchange.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<String> addClient(@Valid @RequestBody ClientRequest clientRequest) {
        Long id = clientService.addClient(clientRequest);
        return new ResponseEntity<>("Client with id " + id + " was added", HttpStatus.OK);
    }
}
