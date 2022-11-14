package com.informed.ExtProject.domain.counterParty;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.server.domain.AddressService;
import com.informed.ExtProject.server.domain.CounterPartyService;
import com.informed.ExtProject.test.util.AddressFactory;
import com.informed.ExtProject.test.util.CounterPartyFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ServiceTestConfig.class})
public class CounterPartyServiceTest {

    public CounterPartyServiceTest() { }

    @Autowired
    private CounterPartyService service;

    @Autowired
    private CounterPartyFactory factory;

    @Autowired
    private AddressService addressService;


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
    @Description("Retrieve all Counter Parties as a list. Check list is of right size and contains correct objects.")
    void testGetAllCounterParties() {

        CounterParty counterParty1 = factory.validCounterParty();
        CounterParty counterParty2 = factory.validCounterPartyEmptyPhone();

        Address address = counterParty1.getAddress();

        addressService.addAddress(address);

        service.addCounterParty(counterParty1);
        service.addCounterParty(counterParty2);

        List<CounterParty> counterParties= service.getAllCounterParties();

        assertThat(counterParties.size()).isEqualTo(2);
        assertThat(counterParties.contains(counterParty1));
        assertThat(counterParties.contains(counterParty2));

        service.removeCounterParty(counterParty1);
        service.removeCounterParty(counterParty2);
        addressService.removeAddressById(address.getId());
    }

    @Test
    @Description("Get Counter Party by ID.")
    void testGetCounterPartyById() {
        CounterParty counterParty = factory.validCounterPartyNullPhone();
        Address address = counterParty.getAddress();
        addressService.addAddress(address);

        service.addCounterParty(counterParty);

        Optional<CounterParty> dbCounterParty = service.getCounterPartyById(counterParty.getId());
        System.out.printf("Retrieved Counter Party: " + dbCounterParty.get());
        assertThat(dbCounterParty.get().toString()).isEqualTo(counterParty.toString());

        service.removeCounterParty(counterParty);
        addressService.removeAddressById(address.getId());
    }

    @Test
    void testAddCounterParty() {
    }

    @Test
    @Description("Update a Counter Party.")
    void updateCounterParty() {
        CounterParty counterParty = factory.validCounterPartyNullEmail();
        Address address = counterParty.getAddress();
        addressService.addAddress(address);

        service.addCounterParty(counterParty);
        service.getCounterPartyById(counterParty.getId());
        counterParty.setName("NewName");
        service.updateCounterParty(counterParty);
        Optional<CounterParty> updatedCounterParty = service.getCounterPartyById(counterParty.getId());
        System.out.println("Updated Counterparty: " + updatedCounterParty.get());
        assertThat(updatedCounterParty.get().getName()).isEqualTo("NewName");
        service.removeCounterParty(counterParty);
        System.out.println(addressService.getAllAddresses());
    }

    @Test
    void removeCounterParty() {
    }

    @Test
    void removeCounterPartyById() {
    }
}