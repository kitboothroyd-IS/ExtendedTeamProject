package com.informed.ExtProject.dao.domain.counterParty;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;

import java.util.List;
import java.util.Optional;

public interface CounterPartyDAO {

    List<CounterParty> getAllCounterParties();

    Optional<CounterParty> getCounterPartyById(int id);

    void addCounterParty(CounterParty counterParty);

    Optional<CounterParty> updateCounterParty(CounterParty counterParty);

    void removeCounterParty(CounterParty counterParty);

    void removeCounterPartyById(int id);
}
