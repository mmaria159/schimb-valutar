package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.CashRequest;
import com.mariamacovei.exchange.service.CashService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cash")
@RequiredArgsConstructor
public class CashController {

    private final CashService cashService;

    @PutMapping
    public ResponseEntity<String> changeAmount(@RequestBody CashRequest request) {
        Long id = cashService.changeAmount(request);
        return new ResponseEntity<>("Cash with id: " + id + " was updated successfully", OK);
    }
}
