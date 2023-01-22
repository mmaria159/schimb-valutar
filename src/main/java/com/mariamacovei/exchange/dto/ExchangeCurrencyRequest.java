package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public final class ExchangeCurrencyRequest {
    @NonNull
    private final String currencyCode;
    @NonNull
    private final BigDecimal amountToExchange;
}
