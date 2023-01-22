package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ExchangeCurrencyRequest;
import com.mariamacovei.exchange.entity.*;
import com.mariamacovei.exchange.exception.CurrencyCodeNoteFoundException;
import com.mariamacovei.exchange.exception.ExchangeRateNotFoundException;
import com.mariamacovei.exchange.exception.NotFoundAnyEmployees;
import com.mariamacovei.exchange.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
        Client client = getRandomClient();
        Employee employee = getRandomEmployee();

        CurrencyDictionary currencyDictionary = currencyDictionaryRepository.findCurrencyDictionaryByCode(request.getCurrencyCode())
                .orElseThrow(() -> new CurrencyCodeNoteFoundException("Currency not found by code: " + request.getCurrencyCode()));

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

    private Employee getRandomEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            throw new NotFoundAnyEmployees("Not found any employees");
        }

        int randomId = (int) ((Math.random() * employees.size()) + 0);
        return employees.get(randomId);
    }

    private Client getRandomClient() {
        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            throw new NotFoundAnyEmployees("Not found any employees");
        }

        int randomId = (int) ((Math.random() * clients.size()) + 0);
        return clients.get(randomId);
    }
}