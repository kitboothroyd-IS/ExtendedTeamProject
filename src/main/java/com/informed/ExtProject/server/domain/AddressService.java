package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.address.AddressDAO;
import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.AddressCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

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

    public Optional<Address> getAddressById(int id){
        return addressDAO.getAddressById(id);
    }

    public void addAddress(Address address) {
        addressDAO.addAddress(address);
    }

    public void updateAddress(Address address) {
        addressDAO.updateAddress(address);
    }

    public void removeAddress(Address address) {
        addressDAO.removeAddress(address);
    }

    public void removeAddressById(int id) {
        addressDAO.removeAddressById(id);
    }
}
