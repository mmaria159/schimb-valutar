package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public final class ExchangeCurrencyRequest {
    @NotBlank(message = "currencyCode is mandatory")
    private final String currencyCode;
    @NotBlank(message = "amountToExchange is mandatory")
    private final BigDecimal amountToExchange;
    @NotBlank(message = "clientId is mandatory")
    private final Long clientId;
    @NotBlank(message = "employeeId is mandatory")
    private final Long employeeId;

}
