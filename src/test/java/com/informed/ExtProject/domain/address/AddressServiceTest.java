package com.informed.ExtProject.domain.address;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.exception.InvalidAddressException;
import com.informed.ExtProject.server.domain.AddressService;
import com.informed.ExtProject.test.util.AddressFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {ServiceTestConfig.class})
public class AddressServiceTest {

    public AddressServiceTest() {

    }
    @Autowired
    private AddressService service;
    @Autowired
    private AddressFactory factory;


    @Test
    void getAllAddresses() {
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses.isEmpty()).isTrue();
    }

    @Test
    @Description("Add valid address (no line2 and line3) to the service and check the added values are correct.")
    void addAndCheckAddress() {
        Address address = factory.validPopulatedAddress();
        service.addAddress(address);
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses)
                .filteredOn(a -> a.getLine1().contains("line1")
                        && a.getLine2() == "line2"
                        && a.getLine3() == "line3"
                        && a.getCity() == "city"
                        && a.getCounty() == "county"
                        && a.getPostcode() == "postcode");
        service.removeAddress(address);
    }

    @Test
    @Description("Add valid address (no line2 and line3) to the service and check the added values are correct.")
    void addAndCheckAddressNoLine2Line3() {
        Address address = factory.validAddressNoLine2Line3();
        service.addAddress(address);
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses)
                .filteredOn(a -> a.getLine1().contains("line1")
                        && a.getLine2() == ""
                        && a.getLine3() == ""
                        && a.getCity() == "city"
                        && a.getCounty() == "county"
                        && a.getPostcode() == "postcode");
        service.removeAddress(address);
    }

    @Test
    @Description("Add a valid address (empty strings in line2 and line3) and check the added values are correct.")
    void addAndCheckAddressEmptyLine2Line3() {
        Address address = factory.validAddressWithEmpties();
        service.addAddress(address);
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses)
                .filteredOn(a -> a.getLine1().contains("line1")
                        && a.getLine2() == ""
                        && a.getLine3() == ""
                        && a.getCity() == "city"
                        && a.getCounty() == "county"
                        && a.getPostcode() == "postcode");
        service.removeAddress(address);
    }

    @Test
    @Description("Add a valid address (nulls in line2 and line3) and check the added values are correct.")
    void addAndCheckAddressNullLine2Line3() {
        Address address = factory.validAddressWithNulls();
        service.addAddress(address);
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses)
                .filteredOn(a -> a.getLine1().contains("line1")
                        && a.getLine2() == null
                        && a.getLine3() == null
                        && a.getCity() == "city"
                        && a.getCounty() == "county"
                        && a.getPostcode().equalsIgnoreCase("postcode"));
        service.removeAddress(address);
    }

    @Test
    @Description("Add an invalid address with all nulls.")
    void invalidAddressWithNulls() {
        Address address = new Address(null, null, null, null, null, null);
        InvalidAddressException thrown = assertThrows(
                InvalidAddressException.class,
                () ->  service.addAddress(address));
        assertTrue(thrown.getMessage().contains("Handling"));
    }

    @Test
    @Description("Add an invalid address with empties.")
    void invalidAddressWithEmpties() {
        Address address = new Address("", "", "", "", "", "");
        InvalidAddressException thrown = assertThrows(
                InvalidAddressException.class,
                () ->  service.addAddress(address));
        assertTrue(thrown.getMessage().contains("Handling"));
    }
}
