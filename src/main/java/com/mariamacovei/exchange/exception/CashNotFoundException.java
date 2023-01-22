package com.mariamacovei.exchange.exception;

public class CashNotFoundException extends RuntimeException {
    public CashNotFoundException(String message) {
        super(message);
    }
}
