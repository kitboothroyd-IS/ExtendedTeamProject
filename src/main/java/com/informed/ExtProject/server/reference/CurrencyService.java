package com.informed.ExtProject.server.reference;

import com.informed.ExtProject.dao.reference.currency.CurrencyDAO;
import com.informed.ExtProject.reference.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CurrencyService {

    private CurrencyDAO currencyDAO;

    @Autowired
    public void setDao(@Qualifier("repoCurrencyDAO") CurrencyDAO currencyDAO){
        this.currencyDAO = currencyDAO;
    }

    public List<Currency> getAllCurrencies() {
        return currencyDAO.getAllCurrencies();
    }

    public void addCurrency(Currency currency) {
        currencyDAO.addCurrency(currency);
    }

    public Optional<Currency> getCurrencyById(int id) {
        return currencyDAO.getCurrencyById(id);
    }
}
