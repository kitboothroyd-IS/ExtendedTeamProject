package com.informed.ExtProject.domain;

import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.server.reference.ForeignExchangeRateService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="equitytrades")
public class EquityTrade {

    @Id
    @GeneratedValue()
    private int id;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="counterParty1Id", nullable = false)
    private CounterParty counterParty1;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="counterParty2Id", nullable = false)
    private CounterParty counterParty2;
    @NotNull
    @DateTimeFormat
    private LocalDate agreementDate;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="equityId", nullable = false)
    private Equity equity;
    @NotNull
    private int amount;
    @NotNull
    private Double price;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="currencyId", nullable = false)
    private Currency currency;
    @NotNull
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="exchangeId", nullable = false)
    private Exchange exchange;

    public EquityTrade() {

    }

    public EquityTrade(CounterParty counterParty1, CounterParty counterParty2, LocalDate agreementDate, Equity equity, int amount, Double price, Currency currency, Exchange exchange) {
        this.counterParty1 = counterParty1;
        this.counterParty2 = counterParty2;
        this.agreementDate = agreementDate;
        this.equity = equity;
        this.amount = amount;
        this.price = price;
        this.currency = currency;
        this.exchange = exchange;
    }

    public int getId() {
        return id;
    }

    public CounterParty getCounterParty1() {
        return counterParty1;
    }

    public void setCounterParty1(CounterParty counterParty1) {
        this.counterParty1 = counterParty1;
    }

    public CounterParty getCounterParty2() {
        return counterParty2;
    }

    public void setCounterParty2(CounterParty counterParty2) {
        this.counterParty2 = counterParty2;
    }

    public LocalDate getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(LocalDate agreementDate) {
        this.agreementDate = agreementDate;
    }

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public double getValueOfTrade() {
        double value = this.amount*this.price;
        return value;
    }

    public double getValueOfTradeInCurrency(Currency newCurrency){
        double exchangeRate = ForeignExchangeRateService.getExchangeRateFor(this.currency, newCurrency);
        double valueInOrigCurrency = getValueOfTrade();
        double valueInNewCurrency = valueInOrigCurrency*exchangeRate;

        return valueInNewCurrency;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquityTrade equityTrade)) return false;
        return getId() == equityTrade.getId();
    }

    public int hashCode() {
        return getId() + getEquity().hashCode();
    }

}
