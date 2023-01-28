package com.mariamacovei.exchange.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public final class ExchangeRateRequest {
    @NotBlank(message = "currencyCode is mandatory")
    private final String currencyCode;
    @NotBlank(message = "rate is mandatory")
    private final BigDecimal rate;
    @NotBlank(message = "exchange is mandatory")
    private final BigDecimal exchange;
    @NotBlank(message = "employeeId is mandatory")
    private final Long employeeId;
}
