package com.mariamacovei.exchange.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.IDENTITY;

// CURS VALUTAR

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal rate;
    private BigDecimal exchange;
    private LocalDateTime createdAt;

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "exchangeRate", cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private List<CurrencyExchange> currencyExchanges = new ArrayList<>();

    @OneToMany(mappedBy = "exchangeRate", cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private List<Cash> cashes = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_dictionary_id", nullable = false)
    private CurrencyDictionary currencyDictionary;
}
