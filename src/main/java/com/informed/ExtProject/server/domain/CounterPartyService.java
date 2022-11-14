package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.counterParty.CounterPartyDAO;
import com.informed.ExtProject.domain.CounterParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@Component
public class CounterPartyService {

    private CounterPartyDAO counterPartyDAO;

    @Autowired
    public void setDao(@Qualifier("repoCounterPartyDAO") CounterPartyDAO counterPartyDAO) {
        this.counterPartyDAO = counterPartyDAO;
    }

    public List<CounterParty> getAllCounterParties() {
        return counterPartyDAO.getAllCounterParties();
    }

    public Optional<CounterParty> getCounterPartyById(int id) {
        return counterPartyDAO.getCounterPartyById(id);
    }

    public void addCounterParty(CounterParty counterParty) {
        // Check that at least the phone number or email are valid
        String phoneNumber = counterParty.getPhoneNumber();
        String emailAddress = counterParty.getEmailAddress();
        if ((phoneNumber == null || phoneNumber.length() < 7 || phoneNumber.length() > 15) &&
                (emailAddress == null || emailAddress.isEmpty())) {
            System.out.println("You must provide a valid email or phone number.");
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>());
        } else {
            counterPartyDAO.addCounterParty(counterParty);
        }
    }

    public Optional<CounterParty> updateCounterParty(CounterParty counterParty) {
        return counterPartyDAO.updateCounterParty(counterParty);
    }

    public void removeCounterParty(CounterParty counterParty) {
        counterPartyDAO.removeCounterParty(counterParty);
    }

    public void removeCounterPartyById(int id) {
        counterPartyDAO.removeCounterPartyById(id);
    }
}
