package com.informed.ExtProject.dao.domain.address;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.NotInListException;
import com.informed.ExtProject.repo.domain.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repoAddressDAO")
public class RepoAddressDAO implements AddressDAO {

  @Autowired
  private AddressRepo addressRepo;

  public List<Address> getAllAddresses() {
    Iterable<Address> searchResults = this.addressRepo.findAll();
    List<Address> addresses = new ArrayList<>();
    searchResults.forEach(addresses::add);
    return addresses;
  }

  public Optional<Address> getAddressById(int id) {
//        List<Address> addresses = getAllAddresses();
//        Address result = addresses.stream()
//          .filter(a -> a.getId() == id)
//          .findFirst()
//          .orElseThrow(RuntimeException::new);

    return this.addressRepo.findById(id);
  }


  @Transactional
  public void addAddress(Address address) {
    this.addressRepo.save(address);
  }


  @Transactional
  public Optional<Address> updateAddress(Address address) {
    int addressId = address.getId();
    return this.addressRepo.findById(addressId).map(dbAddress -> {
      dbAddress.setLine1(address.getLine1());
      dbAddress.setLine2(address.getLine2());
      dbAddress.setLine3(address.getLine3());
      dbAddress.setCity(address.getCity());
      dbAddress.setCounty(address.getCounty());
      dbAddress.setPostcode(address.getPostcode());
      return dbAddress;
    });
  }


  @Transactional
  public void removeAddress(Address address) throws NotInListException {
    try {
      this.addressRepo.delete(address);
      System.out.println("Delete address with: " + address);
    } catch (NotInListException e) {
      e.printStackTrace();
      throw new NotInListException("address");
    }
  }


  @Transactional
  public void removeAddressById(int id) {
    Optional<Address> optionalAddress = this.addressRepo.findById(id);
    if (optionalAddress.isPresent()) {
      System.out.println("Hello");
      this.addressRepo.deleteById(id);
      System.out.println("Deleted address with id: " + id);
    } else {
      System.out.println("Goodbye");
    }
  }


}
