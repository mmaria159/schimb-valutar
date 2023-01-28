package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeCurrencyRequest;
import com.mariamacovei.exchange.entity.*;
import com.mariamacovei.exchange.exception.ClientNotFoundException;
import com.mariamacovei.exchange.exception.CurrencyCodeNotFoundException;
import com.mariamacovei.exchange.exception.EmployeeNotFoundException;
import com.mariamacovei.exchange.exception.ExchangeRateNotFoundException;
import com.mariamacovei.exchange.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeCurrencyServiceImpl implements ExchangeCurrencyService {

    private final ExchangeCurrencyRepository exchangeCurrencyRepository;
    private final ExchangeRateRepository exchangeRateRepository;
    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;
    private final CurrencyDictionaryRepository currencyDictionaryRepository;

    @Override
    public Long addExchangeCurrency(ExchangeCurrencyRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + request.getClientId() + " wasn't found"));

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id: " + request.getEmployeeId()));

        CurrencyDictionary currencyDictionary = currencyDictionaryRepository.findCurrencyDictionaryByCode(request.getCurrencyCode())
                .orElseThrow(() -> new CurrencyCodeNotFoundException("Currency not found by code: " + request.getCurrencyCode()));

        ExchangeRate exchangeRate = exchangeRateRepository.findLastExchangeRateByCurrencyId(currencyDictionary.getId())
                .orElseThrow(() -> new ExchangeRateNotFoundException("Exchange rate not found by code: " + request.getCurrencyCode()));

        Cash cash = new Cash(request.getAmountToExchange(), exchangeRate);

        BigDecimal amountReceived = request.getAmountToExchange().multiply(exchangeRate.getExchange());

        CurrencyExchange currencyExchange = new CurrencyExchange(
                amountReceived,
                client,
                employee,
                cash
        );

        return exchangeCurrencyRepository.save(currencyExchange).getId();
    }
}
