package com.mariamacovei.exchange.exception;

public class CurrencyCodeNotFoundException extends RuntimeException {

    public CurrencyCodeNotFoundException(String message) {
        super(message);
    }
}