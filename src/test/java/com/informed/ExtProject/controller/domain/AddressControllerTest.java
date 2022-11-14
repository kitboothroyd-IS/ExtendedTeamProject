package com.informed.ExtProject.controller.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informed.ExtProject.controller.domain.AddressController;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.config.ServiceTestConfig;
import com.informed.ExtProject.exception.ObjectNotFoundException;
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
        Address address = addressFactory.validAddress();
        String addressAsJSON = asJsonString(address);
        String urlTemplate = "/trader/addresses/list";

        addressController.addAddress(address);

        String mvcResult = mockMvc.perform(get(urlTemplate).contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        String getAddressResult = asJsonString(addressController.getAddresses());
        Assertions.assertThat(mvcResult).isEqualTo(getAddressResult);
    }

    @Test
    public void addValidAddress() throws Exception {
        Address address = addressFactory.validAddress();
        addressController.addAddress(address);
        String addressAsJSON = asJsonString(address);
        String addressListAsJSON = asJsonString(addressController.getAddresses());

        Assertions.assertThat(addressListAsJSON).contains(addressAsJSON);
    }

    @Test
    public void addInvalidAddress() throws Exception {
        Address invalidAddressWithNulls = addressFactory.invalidAddressWithNulls();
        Address invalidAddressWithEmpties = addressFactory.invalidAddressWithEmpties();

        Assertions.assertThatThrownBy(() -> {
            addressController.addAddress(invalidAddressWithNulls);
        }).isInstanceOf(Exception.class);

        Assertions.assertThatThrownBy(() -> {
            addressController.addAddress(invalidAddressWithEmpties);
        }).isInstanceOf(Exception.class);
    }

    @Test
    public void getAddressById() throws Exception{
        Address address = addressFactory.validAddress();
        addressController.addAddress(address);
        String urlTemplate = "/trader/addresses/1";

        Address addressFromGet = addressController.getAddressById(1);

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
            addressController.getAddressById(id);
        }).isInstanceOf(ObjectNotFoundException.class);
    }

    @Test
    public void removeAddress() throws Exception {
        Address address1 = addressFactory.validAddress();
        Address address2 = addressFactory.validAddressWithEmpties();
        addressController.addAddress(address1);
        addressController.addAddress(address2);

        int addressListSizeBefore = addressController.getAddresses().size();
        addressController.removeAddress(address1);
        int addressListSizeAfter = addressController.getAddresses().size();

        Assertions.assertThat(addressListSizeAfter).isEqualTo(addressListSizeBefore-1);
        Assertions.assertThat(asJsonString(addressController.getAddresses())).doesNotContain(asJsonString(address1));
    }

    @Test
    public void removeAddressNotInList() {
        Address address = addressFactory.validAddress();
        Assertions.assertThatThrownBy(() -> {
            addressController.removeAddress(address);
        }).isInstanceOf(ObjectNotFoundException.class);
    }

    @Test
    public void removeAddressById() throws Exception {
        Address address1 = addressFactory.validAddress();
        Address address2 = addressFactory.validAddressWithEmpties();
        addressController.addAddress(address1);
        addressController.addAddress(address2);

        int addressListSizeBefore = addressController.getAddresses().size();
        addressController.removeAddressById(address1.getId());
        int addressListSizeAfter = addressController.getAddresses().size();

        Assertions.assertThat(addressListSizeAfter).isEqualTo(addressListSizeBefore-1);
        Assertions.assertThat(asJsonString(addressController.getAddresses())).doesNotContain(asJsonString(address1));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
