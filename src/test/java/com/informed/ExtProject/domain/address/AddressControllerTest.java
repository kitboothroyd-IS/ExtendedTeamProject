package com.informed.ExtProject.domain.address;
import com.informed.ExtProject.controller.domain.AddressController;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.config.ServiceTestConfig;
import com.informed.ExtProject.exception.ObjectNotFoundException;
import com.informed.ExtProject.test.util.AddressFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = { ServiceTestConfig.class})
@AutoConfigureMockMvc
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
    public void getAddresses(){
        Assertions.assertThatThrownBy(() -> {
            addressController.getAddresses();
        }).isInstanceOf(ObjectNotFoundException.class);
    }

    @Test
    public void addAddress() throws Exception {
        Address address = addressFactory.validAddress();
        addressController.addAddress(address, response);
        String urlTemplate = "/trader/addresses/list";
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("line1")));
    }

    @Test
    public void getAddressById() {
    }
}