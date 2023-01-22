package com.mariamacovei.exchange.dto;

import com.mariamacovei.exchange.entity.CurrencyDictionary;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public final class ExchangeRateResponse {
    private final BigDecimal rate;
    private final BigDecimal exchange;
    private final LocalDateTime createdAt;
    private final CurrencyDictionary currencyDictionary;

    public ExchangeRateResponse(BigDecimal rate,
                                BigDecimal exchange,
                                LocalDateTime createdAt,
                                CurrencyDictionary currencyDictionary) {
        this.rate = rate;
        this.exchange = exchange;
        this.createdAt = createdAt;
        this.currencyDictionary = currencyDictionary;
    }
}
