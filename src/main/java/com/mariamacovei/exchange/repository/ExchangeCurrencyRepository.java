package com.mariamacovei.exchange.repository;

import com.mariamacovei.exchange.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeCurrencyRepository extends JpaRepository<CurrencyExchange, Long> {
}
