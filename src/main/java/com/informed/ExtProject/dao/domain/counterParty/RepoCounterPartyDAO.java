package com.informed.ExtProject.dao.domain.counterParty;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.repo.domain.CounterPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repoCounterPartyDAO")
public class RepoCounterPartyDAO implements CounterPartyDAO {

    @Autowired
    private CounterPartyRepo counterPartyRepo;

    public List<CounterParty> getAllCounterParties() {
        Iterable<CounterParty> searchResults = this.counterPartyRepo.findAll();
        List<CounterParty> counterParties = new ArrayList<>();
        searchResults.forEach(counterParties::add);
        return counterParties;
    }

    public Optional<CounterParty> getCounterPartyById(int id) {
        return this.counterPartyRepo.findById(id);
    }

    @Transactional
    public void addCounterParty(CounterParty counterParty) {
        this.counterPartyRepo.save(counterParty);
        System.out.println("Added Counter Party: " + counterParty);
    }

    @Transactional
    public Optional<CounterParty> updateCounterParty(CounterParty counterParty) {
        int counterPartyId = counterParty.getId();
        return this.counterPartyRepo.findById(counterPartyId).map(dbCounterParty -> {
            dbCounterParty.setName(counterParty.getName());
            dbCounterParty.setPhoneNumber(counterParty.getPhoneNumber());
            dbCounterParty.setEmailAddress(counterParty.getEmailAddress());
            dbCounterParty.setAddress(counterParty.getAddress());
            return dbCounterParty;
        });
    }

    @Transactional
    public void removeCounterParty(CounterParty counterParty) {
        this.counterPartyRepo.delete(counterParty);
        System.out.println("Deleted Counter Party: " + counterParty);
    }

    @Transactional
    public void removeCounterPartyById(int id) {
        this.counterPartyRepo.deleteById(id);
        System.out.println("Deleted Counter Party with ID: " + id);
    }

}
