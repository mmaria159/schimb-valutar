package com.mariamacovei.exchange.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_dictionary_id", nullable = false)
    private CurrencyDictionary currencyDictionary;

    public ExchangeRate(BigDecimal rate, BigDecimal exchange, CurrencyDictionary currencyDictionary, Employee employee) {
        this.rate = rate;
        this.exchange = exchange;
        this.currencyDictionary = currencyDictionary;
        this.employee = employee;
        this.createdAt = now();
    }
}
