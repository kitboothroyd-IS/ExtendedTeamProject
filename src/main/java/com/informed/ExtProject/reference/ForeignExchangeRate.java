package com.informed.ExtProject.reference;

public class ForeignExchangeRate {

    public Currency originCurrency;
    public Currency destinationCurrency;
    public double exchangeRate;

    public ForeignExchangeRate(Currency originCurrency, Currency destinationCurrency, double exchangeRate) {
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.exchangeRate = exchangeRate;
    }
}
