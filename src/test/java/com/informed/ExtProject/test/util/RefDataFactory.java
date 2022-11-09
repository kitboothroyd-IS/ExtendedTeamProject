package com.informed.ExtProject.test.util;

import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.ForeignExchangeRate;

public class RefDataFactory {

    public static void populateForeignExchange() {

        Currency USD = new Currency("United States Dollar", "USD");
        Currency GBP = new Currency("Great British Pounds", "GBP");
        Currency NZD = new Currency("New Zealand Dollar", "NZD");
        Currency YEN = new Currency("Japanese Yen", "YEN");
        Currency AUD = new Currency("Australian Dollar", "AUD");

        ForeignExchangeRate usdGbp = new ForeignExchangeRate(USD, GBP, 1.35);
        ForeignExchangeRate usdNzd = new ForeignExchangeRate(USD, NZD, 1.1);
        ForeignExchangeRate usdYen = new ForeignExchangeRate(USD, YEN, 2);
        ForeignExchangeRate usdAud = new ForeignExchangeRate(USD, AUD, 1);
        ForeignExchangeRate gbpNzd = new ForeignExchangeRate(GBP, NZD, 0.6);
        ForeignExchangeRate gbpYen = new ForeignExchangeRate(GBP, YEN, 1.8);
        ForeignExchangeRate gbpAud = new ForeignExchangeRate(GBP, AUD, 0.7);
        ForeignExchangeRate nzdYen = new ForeignExchangeRate(NZD, YEN, 3);
        ForeignExchangeRate nzdAud = new ForeignExchangeRate(NZD, AUD, 0.9);
        ForeignExchangeRate yenAud = new ForeignExchangeRate(YEN, AUD, 0.8);
    }
}
