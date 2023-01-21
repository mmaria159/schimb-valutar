package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeRateRequest;

public interface ExchangeRateService {

    Long addExchangeRate(ExchangeRateRequest request);
}
