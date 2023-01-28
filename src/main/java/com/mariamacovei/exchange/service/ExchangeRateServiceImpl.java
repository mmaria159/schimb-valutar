package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeRateRequest;
import com.mariamacovei.exchange.dto.ExchangeRateResponse;
import com.mariamacovei.exchange.entity.CurrencyDictionary;
import com.mariamacovei.exchange.entity.Employee;
import com.mariamacovei.exchange.entity.ExchangeRate;
import com.mariamacovei.exchange.exception.CurrencyCodeNoteFoundException;
import com.mariamacovei.exchange.exception.ExchangeRateNotFoundException;
import com.mariamacovei.exchange.exception.NotFoundAnyEmployees;
import com.mariamacovei.exchange.repository.CurrencyDictionaryRepository;
import com.mariamacovei.exchange.repository.EmployeeRepository;
import com.mariamacovei.exchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
                        new CurrencyCodeNoteFoundException("Currency not found by code: " + request.getCurrencyCode()));

        ExchangeRate exchangeRate = new ExchangeRate(
                request.getRate(),
                request.getExchange(),
                currencyDictionary,
                getRandomEmployee());

        return exchangeRateRepository.save(exchangeRate).getId();
    }

    @Override
    public ExchangeRateResponse getExchangeRate(String currencyCode) {
        CurrencyDictionary currencyDictionary = currencyDictionaryRepository.findCurrencyDictionaryByCode(currencyCode)
                .orElseThrow(() -> new CurrencyCodeNoteFoundException("Currency not found by code: " + currencyCode));

        ExchangeRate exchangeRate = exchangeRateRepository.findLastExchangeRateByCurrencyId(currencyDictionary.getId())
                .orElseThrow(() -> new ExchangeRateNotFoundException("Exchange rate not found by code: " + currencyCode));

        return new ExchangeRateResponse(
                exchangeRate.getRate(),
                exchangeRate.getExchange(),
                exchangeRate.getCreatedAt(),
                exchangeRate.getCurrencyDictionary()
        );
    }

    private Employee getRandomEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new NotFoundAnyEmployees("Not found any employees");
        }

        int randomId = (int) ((Math.random() * employees.size()) + 0);
        return employees.get(randomId);
    }
}
