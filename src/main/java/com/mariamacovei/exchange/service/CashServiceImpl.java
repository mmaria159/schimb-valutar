package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.CashRequest;
import com.mariamacovei.exchange.entity.Cash;
import com.mariamacovei.exchange.exception.CashNotFoundException;
import com.mariamacovei.exchange.repository.CashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashServiceImpl implements CashService {

    private final CashRepository cashRepository;

    @Override
    public Long changeAmount(CashRequest request) {
        Cash cash = cashRepository.findById(request.getCashId())
                .orElseThrow(() -> new CashNotFoundException("Cash not found by id: " + request.getCashId()));

        Cash saved = cashRepository.save(new Cash(cash.getId(), request.getAmount(), cash.getExchangeRate()));

        return saved.getId();
    }
}
