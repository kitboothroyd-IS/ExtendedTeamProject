package com.informed.ExtProject.dao.reference.currency;

import com.informed.ExtProject.reference.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyDAO {

    List<Currency> getAllCurrencies();

    void addCurrency(Currency currency);

    Optional<Currency> getCurrencyById(int id);

    void removeCurrencyById(int id);
}
