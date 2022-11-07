package com.informed.ExtProject.reference;

public class ForeignExchangeRates {

    public Currency originCurrency;
    public Currency destinationCurrency;
    public double exchangeRate;

    public ForeignExchangeRates(Currency originCurrency, Currency destinationCurrency, double exchangeRate) {
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.exchangeRate = exchangeRate;
    }
}
