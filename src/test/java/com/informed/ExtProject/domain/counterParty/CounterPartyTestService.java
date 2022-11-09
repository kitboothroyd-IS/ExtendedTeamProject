package com.informed.ExtProject.domain.counterParty;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.server.domain.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

public class CounterPartyTestService {
    @Autowired
    private AddressService addressService;
    @Autowired
    private Address address;

    private Address validAddress = new Address("10 High St", "Wellington", "Greater Wellington", "6011");

    public CounterPartyTestService() {

    }

    public CounterParty validPopulatedCounterParty() {
        addressService.addAddress(validAddress);

        CounterParty counterParty = new CounterParty(
                "name",
                0,
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyWithNull() {
        CounterParty counterParty = new CounterParty(
                "name",
                0,
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyWithEmpty() {
        CounterParty counterParty = new CounterParty(
                "",
                0,
                "",
                validAddress
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyWithNulls() {
        CounterParty counterParty = new CounterParty(
                null,
                345785432,
                null,
                null
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyWithEmpties() {
        CounterParty counterParty = new CounterParty(
                "",
                518406222,
                "",
                null
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyNoAddress() {
        CounterParty counterParty = new CounterParty(
                "name",
                0,
                "emailAddress",
                null
        );
        return counterParty;
    }


}
