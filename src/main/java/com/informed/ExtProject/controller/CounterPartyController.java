package com.informed.ExtProject.controller;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.server.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trader")
public class CounterPartyController {

    private CounterPartyService counterPartyService;

    @Autowired
    public void setCounterPartyService(CounterPartyService counterPartyService) {
        this.counterPartyService = counterPartyService;
    }

    @GetMapping("/counterparties")
    @ResponseStatus(HttpStatus.OK)
    public List<CounterParty> getCounterParties() {
        return counterPartyService.getAllCounterParties();
    }

    @PostMapping("/counterparties")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCounterParty(@RequestBody CounterParty counterParty) {
        System.out.println("AddressController.addAddress(" + counterParty + ")");
        counterPartyService.addCounterParty(counterParty);
    }
}
