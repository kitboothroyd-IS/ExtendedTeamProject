package com.informed.ExtProject.server;

import com.informed.ExtProject.exception.NotInListException;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.reference.RefData;

import java.util.ArrayList;
import java.util.List;

public class RefDataService {
    private static List<Currency> currencyList = new ArrayList<Currency>();
    private static List<Equity> equityList = new ArrayList<Equity>();
    private static List<Exchange> exchangeList = new ArrayList<Exchange>();

    public static void addCurrency(Currency currency) {
        currencyList.add(currency);
    }

    public static void deleteCurrency(Currency currency) {
        if (!currencyList.contains(currency)) {
            throw new NotInListException("currency");
        }
        currencyList.remove(currency);
    }

    public static void addEquity(Equity equity) {
        equityList.add(equity);
    }

    public static void deleteEquity(Equity equity) {
        if (!equityList.contains(equity)) {
            throw new NotInListException("equity");
        }
        equityList.remove(equity);
    }

    public static void addExchange(Exchange exchange) {
        exchangeList.add(exchange);
    }

    public static void deleteExchange(Exchange exchange) {
        if (!exchangeList.contains(exchange)) {
            throw new NotInListException("exchange");
        }
        exchangeList.remove(exchange);
    }
}
