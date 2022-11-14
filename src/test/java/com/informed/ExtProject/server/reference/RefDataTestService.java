package com.informed.ExtProject.server.reference;

import com.informed.ExtProject.config.ServiceTestConfig;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Exchange;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ServiceTestConfig.class})

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
