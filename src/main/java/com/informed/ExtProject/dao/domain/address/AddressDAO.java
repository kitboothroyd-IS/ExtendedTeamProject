package com.informed.ExtProject.dao.domain.address;

import com.informed.ExtProject.domain.Address;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface AddressDAO {
    List<Address> getAllAddresses();

    Address getAddressById(int id, HttpServletResponse response);
    void addAddress(Address address);
    void removeAddress(Address address, HttpServletResponse response);

    void removeAddressById(int id, HttpServletResponse response);
}