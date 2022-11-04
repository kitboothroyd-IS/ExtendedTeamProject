package com.informed.ExtProject.dao.address;

import com.informed.ExtProject.domain.Address;

import java.util.List;

public interface AddressDAO {
    List<Address> getAllAddresses();
    void addAddress(Address address);
}