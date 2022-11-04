package com.informed.ExtProject.server;

import com.informed.ExtProject.dao.AddressDAO;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.NotInListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressService {

    private AddressDAO addressDAO;

    @Autowired
    public void setDao(@Qualifier("repoAddressDAO") AddressDAO addressDAO){
        this.addressDAO = addressDAO;
    }

    public List<Address> getAllAddresses() {
        return addressDAO.getAllAddresses();
    }

    public void addAddress(Address address) {
        addressDAO.addAddress(address);
    }
}
