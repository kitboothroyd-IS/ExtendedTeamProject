package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.config.ServiceTestConfig;
import com.informed.ExtProject.server.domain.AddressService;
import com.informed.ExtProject.server.domain.CounterPartyService;
import com.informed.ExtProject.test.util.CounterPartyFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.test.annotation.Rollback;

import javax.validation.ConstraintViolationException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Rollback
    @Description("Retrieve all Counter Parties as a list. Check list is of right size and contains correct objects.")
    @Order(1)
    void testGetAllCounterParties() {
        // Create two instances of CounterParty and retrieve the embedded address object
        CounterParty counterParty1 = factory.validCounterParty();
        CounterParty counterParty2 = factory.validCounterPartyEmptyPhone();
        Address address = counterParty1.getAddress();

        // Add the CounterParties and address to the database
        addressService.addAddress(address);
        service.addCounterParty(counterParty1);
        service.addCounterParty(counterParty2);

        // Retrieve all CounterParties from the database as a list
        List<CounterParty> counterParties= service.getAllCounterParties();

        // Check that the list contains both
        assertThat(counterParties.size()).isEqualTo(2);
        assertThat(counterParties.contains(counterParty1));
        assertThat(counterParties.contains(counterParty2));

    }

    @Test
    @Rollback
    @Description("Get Counter Party by ID.")
    void testGetCounterPartyById() {
        // Create an instance of CounterParty and retrieve the embedded address object
        CounterParty counterParty = factory.validCounterPartyNullPhone();
        Address address = counterParty.getAddress();

        // Add the CounterParty and address to the database
        addressService.addAddress(address);
        service.addCounterParty(counterParty);

        // Retrieve the newly added CounterParty from the DB and check that it is equal to the instance we created
        Optional<CounterParty> dbCounterParty = service.getCounterPartyById(counterParty.getId());
        System.out.println("Retrieved Counter Party: " + dbCounterParty.get());
        assertThat(dbCounterParty.get().toString()).isEqualTo(counterParty.toString());

    }

    @Test
    @Rollback
    @Description("Test adding valid and invalid counterparties.")
    void testAddCounterParty() {

        // Create some valid instances of CounterParty
        CounterParty counterParty1 = factory.validCounterParty();
        CounterParty counterParty2 = factory.validCounterPartyNullPhone();
        CounterParty counterParty3 = factory.validCounterPartyEmptyPhone();
        CounterParty counterParty4 = factory.validCounterPartyNullEmail();
        CounterParty counterParty5 = factory.validCounterPartyEmptyEmail();

        // Add valid CounterParties to a list
        List<CounterParty> validCounterParties = new ArrayList<>(Arrays.asList(counterParty1,
                counterParty2,
                counterParty3,
                counterParty4,
                counterParty5));

        // Create some invalid instances of CounterParty and add to a list
        CounterParty counterParty6 = factory.invalidCounterPartyEmptyPhoneEmail();
        CounterParty counterParty7 = factory.invalidCounterPartyNullPhoneEmail();
        CounterParty counterParty8 = factory.invalidCounterPartyInvalidPhone();
        CounterParty counterParty9 = factory.invalidCounterPartyWithEmpties();
        CounterParty counterParty10 = factory.invalidCounterPartyNoAddress();
        List<CounterParty> invalidCounterParties = new ArrayList<>(Arrays.asList(counterParty6,
                counterParty7,
                counterParty8,
                counterParty9,
                counterParty10));

        // Create an instance of address and add it via AddressService
        Address address = counterParty1.getAddress();
        addressService.addAddress(address);

        // Iterate through valid CounterParties and check that they are successfully added via AddressService
        for (CounterParty validCounterParty : validCounterParties) {
            service.addCounterParty(validCounterParty);
            Optional<CounterParty> dbResult = service.getCounterPartyById(validCounterParty.getId());
            assertThat(dbResult.get().getName() == validCounterParty.getName());
            assertThat(dbResult.get().getPhoneNumber() == validCounterParty.getPhoneNumber());
            assertThat(dbResult.get().getEmailAddress() == validCounterParty.getEmailAddress());
            assertThat(dbResult.get().getAddress() == validCounterParty.getAddress());
        }

        // Iterate through invalid addresses and check that they throw an error when added via AddressService
        for (CounterParty invalidCounterParty : invalidCounterParties) {
            assertThrows(
                    ConstraintViolationException.class,
                    () -> service.addCounterParty(invalidCounterParty));
            System.out.println("CounterParty not added.");
        }
    }

    @Test
    @Rollback
    @Description("Update a Counter Party.")
    void updateCounterParty() {
        // Create an instance of CounterParty and retrieve the embedded address object
        CounterParty counterParty = factory.validCounterPartyNullEmail();
        Address address = counterParty.getAddress();

        // Add the CounterParty and address to the database
        addressService.addAddress(address);
        service.addCounterParty(counterParty);

        // Retrieve the CounterParty from the database
        service.getCounterPartyById(counterParty.getId());

        // Update the CounterParty name
        counterParty.setName("NewName");
        service.updateCounterParty(counterParty);

        // Retrieve the CounterParty from the database and check it has been correctly updated
        Optional<CounterParty> updatedCounterParty = service.getCounterPartyById(counterParty.getId());
        System.out.println("Updated Counterparty: " + updatedCounterParty.get());
        assertThat(updatedCounterParty.get().getName()).isEqualTo("NewName");
    }

    @Test
    @Rollback
    void removeCounterParty() {
        // Create an instance of CounterParty and retrieve the embedded address object
        CounterParty counterParty = factory.validCounterPartyEmptyEmail();
        Address address = counterParty.getAddress();

        // Add the CounterParty and address to the database
        addressService.addAddress(address);
        service.addCounterParty(counterParty);

        // Delete the CounterParty from the database and check that it no longer exists
        service.removeCounterParty(counterParty);
        Optional<CounterParty> dbResult = service.getCounterPartyById(counterParty.getId());
        assertThat(dbResult.isEmpty());
    }

    @Test
    @Rollback
    void removeCounterPartyById() {
        // Create an instance of CounterParty and retrieve the embedded address object
        CounterParty counterParty = factory.validCounterPartyEmptyPhone();
        Address address = counterParty.getAddress();

        // Add the CounterParty and address to the database
        addressService.addAddress(address);
        service.addCounterParty(counterParty);

        // Delete the CounterParty from the database and check that it no longer exists
        service.removeCounterPartyById(counterParty.getId());
        List<CounterParty> counterParties = service.getAllCounterParties();
        assertThat(counterParties.isEmpty());
    }
}