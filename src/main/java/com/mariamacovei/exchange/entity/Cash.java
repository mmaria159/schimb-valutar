package com.mariamacovei.exchange.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cash {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal amountToExchange;

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}, optional = false)
    @JoinColumn(name = "exchange_rate_id", nullable = false)
    private ExchangeRate exchangeRate;

    public Cash(BigDecimal amountToExchange, ExchangeRate exchangeRate) {
        this.amountToExchange = amountToExchange;
        this.exchangeRate = exchangeRate;
    }
}
