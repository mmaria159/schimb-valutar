package com.mariamacovei.exchange.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.IDENTITY;

// SCHIMB VALUTAR

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private BigDecimal amountReceived;

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}, optional = false)
    @JoinColumn(name = "exchange_rate_id", nullable = false)
    private ExchangeRate exchangeRate;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH}, optional = false)
    @JoinColumn(name = "cash_id", nullable = false)
    private Cash cash;
}
