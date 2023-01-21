package com.mariamacovei.exchange.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CurrencyDictionary {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String code;
    private String name;

    @OneToMany(mappedBy = "currencyDictionary")
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
}
