package com.informed.ExtProject.controller.domain;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.exception.FailedCreationException;
import com.informed.ExtProject.exception.FailedDeletionException;
import com.informed.ExtProject.exception.ObjectNotFoundException;
import com.informed.ExtProject.server.domain.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("trader")
public class CounterPartyController {

    private CounterPartyService counterPartyService;

    @Autowired
    public void setCounterPartyService(CounterPartyService counterPartyService) {
        this.counterPartyService = counterPartyService;
    }

    @GetMapping("/counterparties/list")
    @ResponseStatus(HttpStatus.OK)
    public List<CounterParty> getCounterParties() {
        List<CounterParty> result = counterPartyService.getAllCounterParties();
        if (result.isEmpty()) {
            throw new ObjectNotFoundException("Could not find any Counter Parties");
        } else {
            System.out.println("CounterPartyController.getCounterParties()");
            return result;
        }
    }

    @GetMapping("/counterparties/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CounterParty getCounterPartyById(@PathVariable int id, HttpServletResponse response) {
        Optional<CounterParty> result = counterPartyService.getCounterPartyById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ObjectNotFoundException("Could not find Counter Party with ID" + result);
        }
    }

    @PostMapping("/counterparties")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCounterParty(@RequestBody CounterParty counterParty, HttpServletResponse response) {
        try {
            counterPartyService.addCounterParty(counterParty);
            System.out.println("CounterPartyController.addCounterParty(" + counterParty + ")");
        } catch (FailedCreationException e) {
            throw new FailedCreationException("Failed to create a Counter Party.");
        }
    }


    @PutMapping("/counterparties")
    @ResponseStatus(HttpStatus.OK)
    public void updateCounterParty(@RequestBody CounterParty counterParty, HttpServletResponse response) {
        Optional<CounterParty> counterPartyResult = counterPartyService.getCounterPartyById(counterParty.getId());
        if (counterPartyResult.isPresent()) {
            try {
                System.out.println("CounterPartyController.updateCounterParty with ID " + counterParty.getId() + "(" + counterParty + ")");
                counterPartyService.updateCounterParty(counterParty);
            } catch (IllegalArgumentException e) {
                throw new FailedCreationException("Failed to update Counter Party due to illegal argument.");
            }
        } else {
            throw new ObjectNotFoundException("Failed to find Counter Party with ID " + counterParty.getId());
        }
    }

    //Currently only deleting by ID
    @DeleteMapping("/counterparties")
    @ResponseStatus(HttpStatus.OK)
    public void removeCounterParty(@RequestBody CounterParty counterParty, HttpServletResponse response) {
        Optional<CounterParty> optionalCounterParty = counterPartyService.getCounterPartyById(counterParty.getId());
        if (optionalCounterParty.isPresent()){
            try {
                counterPartyService.removeCounterParty(counterParty);
                System.out.println("CounterPartyController.removeCounterParty(" + counterParty + ")");
            } catch (IllegalArgumentException e){
                throw new FailedDeletionException("Failed to delete Counter Party due to illegal argument");
            }
        } else {
            throw new ObjectNotFoundException("Failed to find Counter Party");
        }
    }

    @DeleteMapping("/counterparties/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCounterPartyById(@PathVariable int id, HttpServletResponse response) {
        Optional<CounterParty> optionalCounterParty = counterPartyService.getCounterPartyById(id);
        if (optionalCounterParty.isPresent()) {
            counterPartyService.removeCounterPartyById(id);
            System.out.println("CounterPartyController.removeCounterParty(" + id + ")");
        } else {
            throw new ObjectNotFoundException("Failed to remove Counter Party with ID:" + id + "does not exist");
        }
    }
}
