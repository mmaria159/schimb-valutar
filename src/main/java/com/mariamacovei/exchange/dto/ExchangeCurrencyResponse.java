package com.mariamacovei.exchange.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public final class ExchangeCurrencyResponse {
    private final Long id;
    private final LocalDateTime createdAt;
    private final BigDecimal amountReceived;

    public ExchangeCurrencyResponse(Long id, LocalDateTime createdAt, BigDecimal amountReceived) {
        this.id = id;
        this.createdAt = createdAt;
        this.amountReceived = amountReceived;
    }
}
