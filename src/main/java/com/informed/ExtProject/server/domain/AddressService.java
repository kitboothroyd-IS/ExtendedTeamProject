package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.address.AddressDAO;
import com.informed.ExtProject.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
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

    public Address getAddressById(int id, HttpServletResponse response){
        return addressDAO.getAddressById(id, response);
    }

    public void addAddress(Address address) {
        addressDAO.addAddress(address);
    }

    public void updateAddress(Address address, HttpServletResponse response) {
        addressDAO.updateAddress(address, response);
    }

    public void removeAddress(Address address, HttpServletResponse response) {
        addressDAO.removeAddress(address, response);
    }

    public void removeAddressById(int id, HttpServletResponse response) {
        addressDAO.removeAddressById(id, response);
    }
}
