package com.informed.ExtProject.test.util;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.test.util.AddressFactory;

public class CounterPartyFactory {

    private AddressFactory addressFactory = new AddressFactory();
    Address validAddress = addressFactory.validAddress();

    public CounterParty validPopulatedCounterParty() {
        CounterParty counterParty = new CounterParty(
                "name",
                "",
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyWithNull() {
        CounterParty counterParty = new CounterParty(
                "name",
                "",
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyWithEmpty() {
        CounterParty counterParty = new CounterParty(
                "",
                "",
                "",
                validAddress
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyWithNulls() {
        CounterParty counterParty = new CounterParty(
                null,
                "345785432",
                null,
                null
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyWithEmpties() {
        CounterParty counterParty = new CounterParty(
                "",
                "518406222",
                "",
                null
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyNoAddress() {
        CounterParty counterParty = new CounterParty(
                "name",
                "",
                "emailAddress",
                null
        );
        return counterParty;
    }
}
