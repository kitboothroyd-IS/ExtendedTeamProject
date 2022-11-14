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

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency getOriginCurrency() {
        return originCurrency;
    }

    public Currency getDestinationCurrency() {
        return destinationCurrency;
    }

    @Override
    public String toString() {
        return "ForeignExchangeRate{" +
                "originCurrency=" + originCurrency +
                ", destinationCurrency=" + destinationCurrency +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
