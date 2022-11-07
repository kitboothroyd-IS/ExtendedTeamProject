package com.informed.ExtProject.controller;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.server.CounterPartyService;
import com.informed.ExtProject.server.EquityTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trader")
public class EquityTradeController {

    private EquityTradeService equityTradeService;

    @Autowired
    public void setEquityTradeService(EquityTradeService equityTradeService) {
        this.equityTradeService = equityTradeService;
    }

    @GetMapping("/equitytrades")
    @ResponseStatus(HttpStatus.OK)
    public List<EquityTrade> getAllEquityTrades() {
        return equityTradeService.getAllEquityTrades();
    }

    @PostMapping("/equitytrades")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEquityTrade(@RequestBody EquityTrade equityTrade) {
        System.out.println("AddressController.addAddress(" + equityTrade + ")");
        equityTradeService.addEquityTrade(equityTrade);
    }
}
