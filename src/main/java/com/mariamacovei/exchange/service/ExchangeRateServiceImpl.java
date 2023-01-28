package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeRateRequest;
import com.mariamacovei.exchange.dto.ExchangeRateResponse;
import com.mariamacovei.exchange.entity.CurrencyDictionary;
import com.mariamacovei.exchange.entity.Employee;
import com.mariamacovei.exchange.entity.ExchangeRate;
import com.mariamacovei.exchange.exception.CurrencyCodeNotFoundException;
import com.mariamacovei.exchange.exception.EmployeeNotFoundException;
import com.mariamacovei.exchange.exception.ExchangeRateNotFoundException;
import com.mariamacovei.exchange.repository.CurrencyDictionaryRepository;
import com.mariamacovei.exchange.repository.EmployeeRepository;
import com.mariamacovei.exchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final EmployeeRepository employeeRepository;
    private final CurrencyDictionaryRepository currencyDictionaryRepository;

    @Override
    public Long addExchangeRate(ExchangeRateRequest request) {
        CurrencyDictionary currencyDictionary = currencyDictionaryRepository
                .findCurrencyDictionaryByCode(request.getCurrencyCode())
                .orElseThrow(() ->
                        new CurrencyCodeNotFoundException("Currency not found by code: " + request.getCurrencyCode()));

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id: " + request.getEmployeeId()));

        ExchangeRate exchangeRate = new ExchangeRate(
                request.getRate(),
                request.getExchange(),
                currencyDictionary,
                employee);

        return exchangeRateRepository.save(exchangeRate).getId();
    }

    @Override
    public ExchangeRateResponse getExchangeRate(String currencyCode) {
        CurrencyDictionary currencyDictionary = currencyDictionaryRepository.findCurrencyDictionaryByCode(currencyCode)
                .orElseThrow(() -> new CurrencyCodeNotFoundException("Currency not found by code: " + currencyCode));

        ExchangeRate exchangeRate = exchangeRateRepository.findLastExchangeRateByCurrencyId(currencyDictionary.getId())
                .orElseThrow(() -> new ExchangeRateNotFoundException("Exchange rate not found by code: " + currencyCode));

        return new ExchangeRateResponse(
                exchangeRate.getRate(),
                exchangeRate.getExchange(),
                exchangeRate.getCreatedAt(),
                exchangeRate.getCurrencyDictionary()
        );
    }
}
