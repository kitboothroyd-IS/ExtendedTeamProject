package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.counterParty.CounterPartyDAO;
import com.informed.ExtProject.domain.CounterParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CounterPartyService {

    private CounterPartyDAO counterPartyDAO;

    @Autowired
    public void setDao(@Qualifier("repoCounterPartyDAO") CounterPartyDAO counterPartyDAO) {
        this.counterPartyDAO = counterPartyDAO;
    }

    public List<CounterParty> getAllCounterParties() {
        return counterPartyDAO.getAllCounterParties();
    }

    public void addCounterParty(CounterParty counterParty) {
        counterPartyDAO.addCounterParty(counterParty);
    }
}
