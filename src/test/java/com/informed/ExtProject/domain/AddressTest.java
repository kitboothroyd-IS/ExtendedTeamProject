package com.informed.ExtProject.domain;

import com.informed.ExtProject.server.domain.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddressTest {

    private AddressService addressServiceTest;

    @Test
    public void addAddressTest() {
        Address test_address = new Address(
                "test_line1",
                "test_line2",
                "test_line3",
                "test_city",
                "test_county",
                "test_postcode");

        addressServiceTest.addAddress(test_address);
    }

}