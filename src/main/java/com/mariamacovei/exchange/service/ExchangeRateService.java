package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeRateRequest;
import com.mariamacovei.exchange.dto.ExchangeRateResponse;

public interface ExchangeRateService {

    Long addExchangeRate(ExchangeRateRequest request);

    ExchangeRateResponse getExchangeRate(String currencyCode);
}
