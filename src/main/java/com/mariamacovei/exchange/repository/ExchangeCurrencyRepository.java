package com.mariamacovei.exchange.repository;

import com.mariamacovei.exchange.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeCurrencyRepository extends JpaRepository<CurrencyExchange, Long> {

//    @Query(value = "SELECT * FROM currency_exchange WHERE client_id = ?1", nativeQuery = true)
//    @Query("SELECT ce FROM CurrencyExchange ce WHERE ce.client.id = ?1")
    List<CurrencyExchange> findCurrencyExchangeByClientId(Long clientId);
}
