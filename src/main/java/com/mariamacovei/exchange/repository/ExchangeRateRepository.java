package com.mariamacovei.exchange.repository;

import com.mariamacovei.exchange.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query(value = "SELECT * FROM exchange_rate e WHERE e.currency_dictionary_id = ?1 AND e.created_at < now() " +
            "ORDER BY created_at DESC LIMIT 1", nativeQuery = true)
    Optional<ExchangeRate> findLastExchangeRateByCurrencyId(Long currencyId);
}
