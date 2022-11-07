package com.informed.ExtProject.domain;

import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Exchange;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="equitytrades")
public class EquityTrade {

    @Id
    @GeneratedValue()
    private int id;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="counterParty1Id", nullable = false)
    private CounterParty counterParty1;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="counterParty2Id", nullable = false)
    private CounterParty counterParty2;
    @NotNull
    private Date agreementDate;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="equityId", nullable = false)
    private Equity equity;
    @NotNull
    private int amount;
    @NotNull
    private Double price;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="currencyId", nullable = false)
    private Currency currency;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="exchangeId", nullable = false)
    private Exchange exchange;

    public EquityTrade(CounterParty counterParty1, CounterParty counterParty2, Date agreementDate, Equity equity, int amount, Double price, Currency currency, Exchange exchange) {
        this.counterParty1 = counterParty1;
        this.counterParty2 = counterParty2;
        this.agreementDate = agreementDate;
        this.equity = equity;
        this.amount = amount;
        this.price = price;
        this.currency = currency;
        this.exchange = exchange;
    }
}
