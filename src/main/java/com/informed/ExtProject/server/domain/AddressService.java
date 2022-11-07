package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.address.AddressDAO;
import com.informed.ExtProject.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
