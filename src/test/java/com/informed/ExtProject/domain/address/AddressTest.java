package com.informed.ExtProject.domain.address;

import com.informed.ExtProject.controller.domain.AddressController;
import com.informed.ExtProject.dao.domain.address.AddressDAO;
import com.informed.ExtProject.dao.domain.address.RepoAddressDAO;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.main.TradingApplication;
import com.informed.ExtProject.repo.domain.AddressRepo;
import com.informed.ExtProject.server.domain.AddressService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

// You should have a test configuration - it needs to be different to the main config - cos of the test database
@SpringBootTest(classes = { ServiceTestConfig.class})
class AddressTest {

    @Autowired
    private AddressService addressService;
    private AddressTestService addressTestService = new AddressTestService();

    @Test
    public void contextLoads() {
        Address address = addressTestService.validPopulatedAddress();
        Assertions.assertThat(address).isNotNull();
    }

    @Test
    public void addValidAddress() {
    }

    @Test
    public void getAllAddresses() {
    }

}
