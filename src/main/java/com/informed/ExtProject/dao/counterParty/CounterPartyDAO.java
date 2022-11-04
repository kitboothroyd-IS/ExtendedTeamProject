package com.informed.ExtProject.dao.counterParty;

import com.informed.ExtProject.domain.CounterParty;

import java.util.List;

public interface CounterPartyDAO {

    List<CounterParty> getAllCounterParties();

    void addCounterParty(CounterParty counterParty);
}
