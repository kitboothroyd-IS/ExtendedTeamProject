package com.informed.ExtProject.dao.domain.counterParty;

import com.informed.ExtProject.domain.CounterParty;

import java.util.List;

public interface CounterPartyDAO {

    List<CounterParty> getAllCounterParties();

    void addCounterParty(CounterParty counterParty);
}
