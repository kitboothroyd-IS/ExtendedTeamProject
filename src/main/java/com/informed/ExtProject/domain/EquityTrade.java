package com.informed.ExtProject.domain;

import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Exchange;
import java.util.Date;

public class EquityTrade {
    private static int newId = 1;

    private int id;
    private CounterParty counterParty1;
    private CounterParty counterParty2;
    private Date agreementDate;
    private Equity equity;
    private int amount;
    private Double price;
    private Currency currency;
    private Exchange exchange;

    public EquityTrade(CounterParty counterParty1, CounterParty counterParty2, Date agreementDate, Equity equity, int amount, Double price, Currency currency, Exchange exchange) {
        this.id = newId;
        newId++;
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
