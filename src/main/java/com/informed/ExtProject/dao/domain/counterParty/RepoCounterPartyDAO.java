package com.informed.ExtProject.dao.domain.counterParty;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.repo.domain.CounterPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("repoCounterPartyDAO")
public class RepoCounterPartyDAO implements CounterPartyDAO{

    @Autowired
    private CounterPartyRepo counterPartyRepo;

    public List<CounterParty> getAllCounterParties() {
        Iterable<CounterParty> searchResults = this.counterPartyRepo.findAll();
        List<CounterParty> counterParties = new ArrayList<>();
        searchResults.forEach(counterParties::add);
        return counterParties;
    }

    @Transactional
    public void addCounterParty(CounterParty counterParty) {this.counterPartyRepo.save(counterParty);}
}
