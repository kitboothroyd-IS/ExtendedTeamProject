package com.informed.ExtProject.domain.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informed.ExtProject.controller.domain.AddressController;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.exception.AddressNotFoundException;
import com.informed.ExtProject.exception.InvalidAddressException;
import com.informed.ExtProject.test.util.AddressFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(classes = { ServiceTestConfig.class})
@AutoConfigureMockMvc
@EnableWebMvc
public class AddressControllerTest {

    @Autowired
    ConfigurableApplicationContext applicationContext;
    @Autowired
    private AddressController addressController;
    @Autowired
    HttpServletResponse response;
    @Autowired
    MockMvc mockMvc;

    private AddressFactory addressFactory = new AddressFactory();

    @BeforeEach
    public void setup() {
    }

    @Test
    public void contextLoads() {
        Assertions.assertThat(addressController).isNotNull();
    }

    @Test
    public void getAddresses() throws Exception {
        Address address = addressFactory.validPopulatedAddress();
        String addressAsJSON = asJsonString(address);
        String urlTemplate = "/trader/addresses/list";

        addressController.addAddress(address, response);

        String mvcResult = mockMvc.perform(get(urlTemplate).contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        String getAddressResult = asJsonString(addressController.getAddresses());
        Assertions.assertThat(mvcResult).isEqualTo(getAddressResult);
    }

    @Test
    public void addValidAddress() throws Exception {
        Address address = addressFactory.validPopulatedAddress();
        addressController.addAddress(address, response);
        String addressAsJSON = asJsonString(address);
        String addressListAsJSON = asJsonString(addressController.getAddresses());

        Assertions.assertThat(addressListAsJSON).contains(addressAsJSON);
    }

    @Test
    public void addInvalidAddress() throws Exception {
        Address invalidAddressWithNulls = addressFactory.invalidAddressWithNulls();
        Address invalidAddressWithEmpties = addressFactory.invalidAddressWithEmpties();

        Assertions.assertThatThrownBy(() -> {
            addressController.addAddress(invalidAddressWithNulls, response);
        }).isInstanceOf(InvalidAddressException.class);

        Assertions.assertThatThrownBy(() -> {
            addressController.addAddress(invalidAddressWithEmpties, response);
        }).isInstanceOf(InvalidAddressException.class);
    }

    @Test
    public void getAddressById() throws Exception{
        Address address = addressFactory.validPopulatedAddress();
        addressController.addAddress(address, response);
        String urlTemplate = "/trader/addresses/1";

        Address addressFromGet = addressController.getAddressById(1, response);

        String addressFromMvc = mockMvc.perform(get(urlTemplate))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertThat(addressFromMvc).isEqualTo(asJsonString(addressFromGet));
    }

    @Test
    public void getAddressByIdNotInList() {
        int id = 1000;
        Assertions.assertThatThrownBy(() -> {
            addressController.getAddressById(id, response);
        }).isInstanceOf(AddressNotFoundException.class);
    }

    @Test
    public void removeAddress() throws Exception {
        Address address1 = addressFactory.validPopulatedAddress();
        Address address2 = addressFactory.validAddressWithEmpties();
        addressController.addAddress(address1, response);
        addressController.addAddress(address2, response);

        int addressListSizeBefore = addressController.getAddresses().size();
        addressController.removeAddress(address1, response);
        int addressListSizeAfter = addressController.getAddresses().size();

        Assertions.assertThat(addressListSizeAfter).isEqualTo(addressListSizeBefore-1);
        Assertions.assertThat(asJsonString(addressController.getAddresses())).doesNotContain(asJsonString(address1));
    }

    @Test
    public void removeAddressNotInList() {
        Address address = addressFactory.validPopulatedAddress();
        Assertions.assertThatThrownBy(() -> {
            addressController.removeAddress(address, response);
        }).isInstanceOf(AddressNotFoundException.class);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
