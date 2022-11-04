package com.informed.ExtProject.server;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.exception.NotInListException;

import java.util.ArrayList;
import java.util.List;

public class CounterPartyService {
    private static List<CounterParty> counterPartyList = new ArrayList<CounterParty>();

    public static void addCounterParty(CounterParty counterParty) {
        counterPartyList.add(counterParty);
    }

    public static void deleteCounterParty(CounterParty counterParty) {
        if (!counterPartyList.contains(counterParty)) {
            throw new NotInListException("counter party");
        }
        counterPartyList.remove(counterParty);
    }
}
