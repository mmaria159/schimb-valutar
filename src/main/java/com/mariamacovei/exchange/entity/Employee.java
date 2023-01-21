package com.mariamacovei.exchange.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String function;

    @OneToMany(mappedBy = "employee", cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private List<CurrencyExchange> currencyExchanges = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
}
