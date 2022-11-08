package com.informed.ExtProject.dao.reference.currency;

import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.repo.reference.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("repoCurrencyDAO")
public class RepoCurrencyDAO implements CurrencyDAO {

    @Autowired
    private CurrencyRepo currencyRepo;

    public List<Currency> getAllCurrencies() {
        Iterable<Currency> searchResults = this.currencyRepo.findAll();
        List<Currency> currencies = new ArrayList<>();
        searchResults.forEach(currencies::add);
        return currencies;
    }

    @Transactional
    public void addCurrency(Currency currency) {
        this.currencyRepo.save(currency);
    }

}
