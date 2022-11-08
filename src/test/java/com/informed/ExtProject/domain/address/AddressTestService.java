package com.informed.ExtProject.domain.address;

import com.informed.ExtProject.domain.Address;

public class AddressTestService {

    public AddressTestService(){

    }

    public Address validPopulatedAddress() {
        Address address = new Address(
                "line1",
                "line2",
                "line3",
                "city",
                "county",
                "postcode"
        );
        return address;
    }

    public Address validAddressWithNulls() {
        Address address = new Address(
                "line1",
                null,
                null,
                "city",
                "county",
                "postcode"
        );
        return address;
    }

    public Address validAddressWithEmpties() {
        Address address = new Address(
                "line1",
                "",
                "",
                "city",
                "county",
                "postcode"
        );
        return address;
    }

    public Address invalidAddressWithNulls() {
        Address address = new Address(
                null,
                null,
                null,
                null,
                null,
                null
        );
        return address;
    }

    public Address invalidAddressWithEmpties() {
        Address address = new Address(
                "",
                "",
                "",
                "",
                "",
                ""
        );
        return address;
    }
}
