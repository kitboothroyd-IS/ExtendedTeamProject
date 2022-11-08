package com.informed.ExtProject.dao.domain.address;

import com.informed.ExtProject.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDAO {

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(int id);
    void addAddress(Address address);

    Optional<Address> updateAddress(Address address);
    void removeAddress(Address address);

    void removeAddressById(int id);
}