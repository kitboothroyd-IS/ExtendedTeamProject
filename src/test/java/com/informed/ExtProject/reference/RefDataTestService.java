package com.informed.ExtProject.reference;

public class RefDataTestService {

    public RefDataTestService() {

    }

    public Currency validCurrency() {
        return new Currency("name", "symbol");
    }

    public Currency invalidCurrency() {
        return new Currency(null, "");
    }

    public Exchange validExchange() {
        return new Exchange("name", "symbol");
    }

    public Exchange invalidExchange() {
        return new Exchange(null, "");
    }

    public Equity validEquity() {
        return new Equity("name", "symbol");
    }

    public Equity invalidEquity() {
        return new Equity(null, "");
    }
}
