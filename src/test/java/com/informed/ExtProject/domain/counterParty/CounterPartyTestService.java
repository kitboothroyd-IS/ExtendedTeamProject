package com.informed.ExtProject.domain.counterParty;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.address.AddressTestService;

public class CounterPartyTestService {

    private AddressTestService addressTestService;
    private Address validAddress = addressTestService.validPopulatedAddress();

    public CounterPartyTestService() {

    }

    public CounterParty validPopulatedCounterParty() {
        CounterParty counterParty = new CounterParty(
                "name",
                "phoneNumber",
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyWithNull() {
        CounterParty counterParty = new CounterParty(
                "name",
                null,
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyWithEmpty() {
        CounterParty counterParty = new CounterParty(
                "",
                "phoneNumber",
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyWithNulls() {
        CounterParty counterParty = new CounterParty(
                null,
                null,
                null,
                null
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyWithEmpties() {
        CounterParty counterParty = new CounterParty(
                "",
                "",
                "",
                null
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyNoAddress() {
        CounterParty counterParty = new CounterParty(
                "name",
                "phoneNumber",
                "emailAddress",
                null
        );
        return counterParty;
    }


}
