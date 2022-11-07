package com.informed.ExtProject.reference;

public class ForeignExchangeRates {

    public Currency origin_currency;
    public Currency destination_currency;
    public double exchange_rate;

    public ForeignExchangeRates(Currency origin_currency, Currency destination_currency, double exchange_rate) {
        this.origin_currency = origin_currency;
        this.destination_currency = destination_currency;
        this.exchange_rate = exchange_rate;
    }
}
