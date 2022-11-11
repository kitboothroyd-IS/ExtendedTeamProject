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

        addressService.addAddress(counterParty1.getAddress());

        service.addCounterParty(counterParty1);
        service.addCounterParty(counterParty2);

        List<CounterParty> counterParties= service.getAllCounterParties();

        assertThat(counterParties.size()).isEqualTo(2);
        assertThat(counterParties.contains(counterParty1));
        assertThat(counterParties.contains(counterParty2));

        service.removeCounterParty(counterParty1);
        service.removeCounterParty(counterParty2);
        addressService.removeAddress(counterParty1.getAddress());
    }

    @Test
    void testGetCounterPartyById() {
    }

    @Test
    void testAddCounterParty() {
    }

    @Test
    void updateCounterParty() {
    }

    @Test
    void removeCounterParty() {
    }

    @Test
    void removeCounterPartyById() {
    }
}