package com.informed.ExtProject.domain.address;

import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.server.domain.AddressService;
import com.informed.ExtProject.test.util.AddressFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// You should have a test configuration - it needs to be different to the main config - cos of the test database
@SpringBootTest(classes = { ServiceTestConfig.class})
class AddressServiceTest {

    @Autowired
    private AddressService addressService;
    private AddressFactory addressFactory = new AddressFactory();

    @Test
    public void contextLoads() {
        Assertions.assertThat(addressService).isNotNull();
    }

    @Test
    public void addValidAddress() {
    }

    @Test
    public void getAllAddresses() {
    }

}
