package com.informed.ExtProject.test.util;
import com.informed.ExtProject.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressFactory {

    public AddressFactory(){

    }

    public Address validAddress() {
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

    public Address validAddressNoLine2Line3() {
        Address address = new Address(
                "line1",
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

