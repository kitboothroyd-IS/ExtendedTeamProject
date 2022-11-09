package com.informed.ExtProject.controller.domain;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.AddressCreationException;
import com.informed.ExtProject.exception.AddressDeletionException;
import com.informed.ExtProject.exception.AddressNotFoundException;
import com.informed.ExtProject.server.domain.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TransactionRequiredException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("trader")
public class AddressController {

  private AddressService addressService;

  @Autowired
  public void setAddressService(AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping("/addresses/list")
  @ResponseStatus(HttpStatus.OK)
  public List<Address> getAddresses() {
    List<Address> result = addressService.getAllAddresses();
    if (result.isEmpty()) {
      throw new AddressNotFoundException("Could not find any addresses");
    } else {
      System.out.println("AddressController.getAddresses()");
      return result;
    }

  }

  @GetMapping("/addresses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Address getAddressById(@PathVariable int id, HttpServletResponse response) {
    Optional<Address> result = addressService.getAddressById(id);
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new AddressNotFoundException("Could not find address with ID" + result);
    }

  }

//        System.out.println("AddressController.getId()");
//        return addressService.getAddressById(id);


  @PostMapping("/addresses")
  @ResponseStatus(HttpStatus.CREATED)
  public void addAddress(@RequestBody Address address, HttpServletResponse response) {
    if (address != null) {
      addressService.addAddress(address);
      //            System.out.println("AddressController.addAddress(" + address + ")");
    } else {
      throw new AddressCreationException("Failed to create an address");
    }
  }


  @PutMapping("/addresses")
  @ResponseStatus(HttpStatus.OK)
  public void updateAddress(@RequestBody Address address, HttpServletResponse response) {
    Optional<Address> addressResult = addressService.getAddressById(address.getId());
    if (addressResult.isPresent()) {
      try {
        System.out.println("AddressController.updateAddress with ID " + address.getId() + "(" + address + ")");
        addressService.updateAddress(address);
      } catch (IllegalArgumentException e) {
        throw new AddressCreationException("Failed to update address due to illegal argument.");
      }
    } else {
      throw new AddressNotFoundException("Failed to find address with ID " + address.getId());
    }
  }

  //Currently only deleting by ID
  @DeleteMapping("/addresses")
  @ResponseStatus(HttpStatus.OK)
  public void removeAddress(@RequestBody Address address, HttpServletResponse response) {
    Optional<Address> optionalAddressById = addressService.getAddressById(address.getId());
    if (optionalAddressById.isPresent()){
      try {
        addressService.removeAddress(address);
        System.out.println("AddressController.removeAddress(" + address + ")");
      } catch (IllegalArgumentException e){
        throw new AddressDeletionException("Failed to delete address due to illegal argument");
      }
    } else {
      throw new AddressNotFoundException("Failed to find address");
    }
  }

  @DeleteMapping("/addresses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void removeAddressById(@PathVariable int id, HttpServletResponse response) {
    Optional<Address> optionalAddress = addressService.getAddressById(id);
    if (optionalAddress.isPresent()) {
      addressService.removeAddressById(id);
      System.out.println("AddressController.removeAddressById(" + id + ")");
    } else {
      throw new AddressNotFoundException("Failed to remove address as address with ID:" + id + "does not exist");
    }
  }

  @ExceptionHandler(AddressNotFoundException.class)
  @ResponseStatus(
    value = HttpStatus.NOT_ACCEPTABLE,
    reason = "Address not found")
  public void addressNotFoundFailure() {
    System.out.println("Handling error for address.");
  }

  @ExceptionHandler(AddressCreationException.class)
  @ResponseStatus(
    value = HttpStatus.NOT_IMPLEMENTED,
    reason = "Cannot create/update this address")
  public void addressCreationFailure() {
    System.out.println("Handling error for address.");
  }

}


