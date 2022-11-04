package com.informed.ExtProject.server;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.NotInListException;

import java.util.ArrayList;
import java.util.List;

public class AddressService {
    private static List<Address> addressList = new ArrayList<Address>();

    public static void addAddress(Address address) {
        addressList.add(address);
    }

    public static void deleteAddress(Address address) {
        if (!addressList.contains(address)) {
            throw new NotInListException("address");
        }
        addressList.remove(address);
    }

    public static String getAddresses() {
        return addressList.toString();
    }
}
