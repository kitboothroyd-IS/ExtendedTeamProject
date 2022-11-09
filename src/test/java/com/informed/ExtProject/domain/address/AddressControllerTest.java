package com.informed.ExtProject.domain.address;

import com.informed.ExtProject.controller.domain.AddressController;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.exception.AddressNotFoundException;
import com.informed.ExtProject.test.util.AddressFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@SpringBootTest(classes = { ServiceTestConfig.class})
public class AddressControllerTest {

    @Autowired
    private AddressController addressController;
    @Autowired
    HttpServletResponse response;
    private AddressFactory addressFactory = new AddressFactory();

    @Test
    public void contextLoads() {
        Assertions.assertThat(addressController).isNotNull();
    }

    @Test
    public void getAddresses(){
        Assertions.assertThatThrownBy(() -> {
            addressController.getAddresses();
        }).isInstanceOf(AddressNotFoundException.class);
    }

    @Test
    public void addAddress() {
        Address validPopulatedAddress = addressFactory.validAddress();
        addressController.addAddress(validPopulatedAddress, response);
        List<Address> addressList = addressController.getAddresses();
        Assertions.assertThat(addressList.get(addressList.size()-1).getId()).isEqualTo(validPopulatedAddress.getId());

        Address invalidAddressWithNulls = addressFactory.invalidAddressWithNulls();
        Assertions.assertThatThrownBy(() -> {
              addressController.addAddress(invalidAddressWithNulls, response);
          }).isInstanceOf(Exception.class);

        Address invalidAddressWithEmpties = addressFactory.invalidAddressWithEmpties();
        Assertions.assertThatThrownBy(() -> {
            addressController.addAddress(invalidAddressWithEmpties, response);
        }).isInstanceOf(Exception.class);
    }
}
