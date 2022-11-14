package com.informed.ExtProject.domain;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.config.ServiceTestConfig;
import com.informed.ExtProject.server.domain.CounterPartyService;
import com.informed.ExtProject.test.util.CounterPartyFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { ServiceTestConfig.class})
public class CounterPartyTest {

    @Autowired
    private CounterPartyService counterPartyService;
    private CounterPartyFactory counterPartyFactory = new CounterPartyFactory();

    @Test
    public void contextLoads() {
        CounterParty counterParty = counterPartyFactory.validCounterParty();
        Assertions.assertThat(counterParty).isNotNull();
    }
}
