package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public final class CashRequest {
    private final Long cashId;
    private final BigDecimal amount;
}
