package com.informed.ExtProject.test.util;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.test.util.AddressFactory;
import org.springframework.stereotype.Component;

@Component
public class CounterPartyFactory {

    private AddressFactory addressFactory = new AddressFactory();
    Address validAddress = addressFactory.validAddress();

    public CounterParty validCounterParty() {
        CounterParty counterParty = new CounterParty(
                "name",
                "123456789",
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyNullPhone() {
        CounterParty counterParty = new CounterParty(
                "name",
                null,
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyEmptyPhone() {
        CounterParty counterParty = new CounterParty(
                "name",
                "",
                "emailAddress",
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyNullEmail() {
        CounterParty counterParty = new CounterParty(
                "name",
                "123456789",
                null,
                validAddress
        );
        return counterParty;
    }

    public CounterParty validCounterPartyEmptyEmail() {
        CounterParty counterParty = new CounterParty(
                "name",
                "123456789",
                "",
                validAddress
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyEmptyPhoneEmail() {
        CounterParty counterParty = new CounterParty(
                "name",
                "",
                "",
                validAddress
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyNullPhoneEmail() {
        CounterParty counterParty = new CounterParty(
                "name",
                null,
                null,
                validAddress
        );
        return counterParty;
    }

    public CounterParty invalidCounterPartyInvalidPhone() {
        CounterParty counterParty = new CounterParty(
                "name",
                "12345",
                null,
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
