package com.informed.ExtProject.dao.reference.currency;

import com.informed.ExtProject.reference.Currency;

import java.util.List;

public interface CurrencyDAO {

    List<Currency> getAllCurrencies();

    void addCurrency(Currency currency);
}
