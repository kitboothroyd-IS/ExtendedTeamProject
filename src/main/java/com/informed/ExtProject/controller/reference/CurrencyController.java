package com.informed.ExtProject.controller.reference;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.server.reference.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trader")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currencies")
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getCurrencies() {
        System.out.println("CurrencyController.getCurrencies()");
        return currencyService.getAllCurrencies();
    }

    @PostMapping("/currencies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCurrency(@RequestBody Currency currency) {
        System.out.println("CurrencyController.addCurrency(" + currency + ")");
        currencyService.addCurrency(currency);
    }

}
