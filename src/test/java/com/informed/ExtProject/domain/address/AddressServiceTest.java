package com.informed.ExtProject.domain.address;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.server.domain.AddressService;
import com.informed.ExtProject.test.util.AddressFactory;
import jdk.jfr.Description;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {ServiceTestConfig.class})
public class AddressServiceTest {

    public AddressServiceTest() {

    }
    @Autowired
    private AddressService service;
    @Autowired
    private AddressFactory factory;


    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass()");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    @Description("Retrieve all addresses in a list. List should be empty.")
    void testGetAllAddresses() {
        Address address = factory.validAddress();
        Address address1 = factory.validAddressNoLine2Line3();

        service.addAddress(address);
        service.addAddress(address1);

        List<Address> addresses = service.getAllAddresses();

        assertThat(addresses.size()).isEqualTo(2);
        assertThat(addresses.contains(address));
        assertThat(addresses.contains(address1));

        service.removeAddress(address);
        service.removeAddress(address1);
    }

    @Test
    @Description("Get address by ID.")
    void testGetAddressByIdTest() {
        Address address = factory.validAddressWithEmpties();
        service.addAddress(address);
        Optional<Address> dbAddress = service.getAddressById(address.getId());
        System.out.println("Retrieved address: " + dbAddress.get());
        assertThat(dbAddress.get().toString()).isEqualTo(address.toString());
        service.removeAddress(address);
    }

    @Test
    @Description("Add valid address (no line2 and line3) to the service and check the added values are correct.")
    void testAddValidAddress() {
        Address address = factory.validAddress();
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
    void testAddValidAddressNoLine2Line3() {
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
    void testAddValidAddressEmptyLine2Line3() {
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
    void testAddValidAddressNullLine2Line3() {
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
    void testAddInvalidAddressAllNulls() {
        Address address = factory.invalidAddressWithNulls();
        Assertions.assertThatThrownBy(() -> {
            service.addAddress(address);
        }).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @Description("Add an invalid address with empties.")
    void testAddInvalidAddressAllEmpty() {
        Address address = factory.invalidAddressWithEmpties();
        Assertions.assertThatThrownBy(() -> {
                    service.addAddress(address);
                }).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @Description("Update an address.")
    void testUpdateAddress() {
        Address address = factory.validAddressNoLine2Line3();
        service.addAddress(address);
        service.getAddressById(address.getId());
        address.setCity("updatedCity");
        service.updateAddress(address);
        Optional<Address> updatedAddress = service.getAddressById(address.getId());
        System.out.println("Updated address: " + updatedAddress.get());
        assertThat(updatedAddress.get().getCity()).isEqualTo("updatedCity");
        service.removeAddress(updatedAddress.get());
    }

    @Test
    @Description("Remove an address.")
    void testRemoveAddress() {
        Address address = factory.validAddressWithNulls();
        service.addAddress(address);
        service.removeAddress(address);
        Optional<Address> dbResult = service.getAddressById(address.getId());
        assertThat(dbResult.isEmpty());
    }

    @Test
    @Description("Remove an address by ID.")
    void testRemoveAddressById() {
        Address address = factory.validAddressWithNulls();
        service.addAddress(address);
        service.removeAddressById(address.getId());
        Optional<Address> dbResult = service.getAddressById(address.getId());
        assertThat(dbResult.isEmpty());
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses.isEmpty());
    }

}
