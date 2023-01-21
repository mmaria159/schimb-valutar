package com.mariamacovei.exchange.repository;

import com.mariamacovei.exchange.entity.CurrencyDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyDictionaryRepository extends JpaRepository<CurrencyDictionary, Long> {

    Optional<CurrencyDictionary> findCurrencyDictionaryByCode(String currencyCode);
}
