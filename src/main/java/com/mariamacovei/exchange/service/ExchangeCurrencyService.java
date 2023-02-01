package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeCurrencyRequest;
import com.mariamacovei.exchange.dto.ExchangeCurrencyResponse;

import java.util.List;

public interface ExchangeCurrencyService {

    Long addExchangeCurrency(ExchangeCurrencyRequest request);
   List<ExchangeCurrencyResponse> findCurrencyExchangeByClientId(Long id);
}
