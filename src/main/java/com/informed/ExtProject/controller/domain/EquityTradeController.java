package com.informed.ExtProject.controller.domain;

import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.exception.FailedCreationException;
import com.informed.ExtProject.exception.FailedDeletionException;
import com.informed.ExtProject.exception.ObjectNotFoundException;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.server.domain.EquityTradeService;
import com.informed.ExtProject.server.reference.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("trader")
public class EquityTradeController {

    private EquityTradeService equityTradeService;
    @Autowired
    CurrencyService currencyService;

    @Autowired
    public void setEquityTradeService(EquityTradeService equityTradeService) {
        this.equityTradeService = equityTradeService;
    }

    @GetMapping("/equitytrades/list")
    @ResponseStatus(HttpStatus.OK)
    public List<EquityTrade> getAllEquityTrades() {
        List<EquityTrade> result = equityTradeService.getAllEquityTrades();
        if (result.isEmpty()) {
            throw new ObjectNotFoundException("Could not find any Equity Trades");
        } else {
            System.out.println("EquityTradeController.getAllEquityTrades()");
            return result;
        }
    }


    @GetMapping("/equitytrades/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EquityTrade getEquityTradeById(@PathVariable int id) {
        Optional<EquityTrade> result = equityTradeService.getEquityTradeById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ObjectNotFoundException("Could not find Equity Trade with ID" + result);
        }
    }

    @PostMapping("/equitytrades")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEquityTrade(@RequestBody EquityTrade equityTrade) {
        try {
            equityTradeService.addEquityTrade(equityTrade);
            System.out.println("EquityTradeController.addEquityTrade(" + equityTrade + ")");
        } catch (FailedCreationException e) {
            throw new FailedCreationException("Failed to create an Equity Trade.");
        }
    }

    @PutMapping("/equitytrades")
    @ResponseStatus(HttpStatus.OK)
    public void updateEquityTrade(@RequestBody EquityTrade equityTrade) {
        Optional<EquityTrade> equityTradeResult = equityTradeService.getEquityTradeById(equityTrade.getId());
        if (equityTradeResult.isPresent()) {
            try {
                System.out.println("EquityTradeController.updateEquityTrade with ID " + equityTrade.getId() + "(" + equityTrade + ")");
                equityTradeService.updateEquityTrade(equityTrade);
            } catch (IllegalArgumentException e) {
                throw new FailedCreationException("Failed to update Equity Trade due to illegal argument.");
            }
        } else {
            throw new ObjectNotFoundException("Failed to find Equity Trade with ID " + equityTrade.getId());
        }
    }

    @DeleteMapping("/equitytrades")
    @ResponseStatus(HttpStatus.OK)
    public void removeEquityTrade(@RequestBody EquityTrade equityTrade) {
        Optional<EquityTrade> optionalEquityTrade = equityTradeService.getEquityTradeById(equityTrade.getId());
        if (optionalEquityTrade.isPresent()){
            try {
                equityTradeService.removeEquityTrade(equityTrade);
                System.out.println("EquityTradeController.removeEquityTrade(" + equityTrade + ")");
            } catch (IllegalArgumentException e){
                throw new FailedDeletionException("Failed to delete Equity Trade due to illegal argument");
            }
        } else {
            throw new ObjectNotFoundException("Failed to find Equity Trade");
        }
    }

    @DeleteMapping("/equitytrades/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeEquityTradeById(@PathVariable int id) {
        Optional<EquityTrade> optionalEquityTrade = equityTradeService.getEquityTradeById(id);
        if (optionalEquityTrade.isPresent()) {
            equityTradeService.removeEquityTradeById(id);
            System.out.println("EquityTradeController.removeEquityTrade(" + id + ")");
        } else {
            throw new ObjectNotFoundException("Failed to remove Equity Trade with ID:" + id + "does not exist");
        }
    }

    @GetMapping("/equitytrades/{id}/value")
    @ResponseStatus(HttpStatus.OK)
    public double getTradeValueById(@PathVariable int id) {
        Optional<EquityTrade> optionalEquityTrade = equityTradeService.getEquityTradeById(id);
        double value = -1.0;
        if (optionalEquityTrade.isPresent()) {
            EquityTrade equityTrade = optionalEquityTrade.get();
            value = equityTrade.getValueOfTrade();
        }

        return value;
    }

    @GetMapping("/equitytrades/{id}/value/{currencyId}")
    @ResponseStatus(HttpStatus.OK)
    public double getTradeValueByIdInCurrency(@PathVariable("id") int id, @PathVariable("currencyId") int currencyId) {
        Optional<EquityTrade> optionalEquityTrade = equityTradeService.getEquityTradeById(id);
        Optional<Currency> optionalCurrency = currencyService.getCurrencyById(currencyId);
        double value = -1.0;
        if (optionalEquityTrade.isPresent() && optionalCurrency.isPresent()) {
            EquityTrade equityTrade = optionalEquityTrade.get();
            Currency currency = optionalCurrency.get();
            value = equityTrade.getValueOfTradeInCurrency(currency);
        }

        return value;
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(
      value = HttpStatus.NOT_ACCEPTABLE,
      reason = "Equity Trade not found")
    public void ObjectNotFoundException() {
        System.out.println("Handling error for Equity Trade.");
    }

    @ExceptionHandler(FailedCreationException.class)
    @ResponseStatus(
      value = HttpStatus.NOT_IMPLEMENTED,
      reason = "Cannot create/update Equity Trade")
    public void FailedCreationException() {
        System.out.println("Handling error for Equity Trade.");
    }


}
