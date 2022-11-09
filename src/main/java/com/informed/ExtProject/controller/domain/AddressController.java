package com.informed.ExtProject.controller.domain;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.InvalidAddressException;
import com.informed.ExtProject.exception.AddressNotFoundException;
import com.informed.ExtProject.exception.NotInListException;
import com.informed.ExtProject.server.domain.AddressService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
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
    try {
      return addressService.getAddressById(id).get();
    } catch (NotInListException e) {
      throw new AddressNotFoundException("The address you have tried to get does not exist in the address list.");
    }
  }

  @PostMapping("/addresses")
  @ResponseStatus(HttpStatus.CREATED)
  public void addAddress(@RequestBody Address address, HttpServletResponse response) {
    try {
      addressService.addAddress(address);
    } catch (ConstraintViolationException e) {
      throw new InvalidAddressException("Not a valid address.");
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
        throw new InvalidAddressException("Failed to update address due to illegal argument.");
      }
    } else {
      throw new AddressNotFoundException("Failed to find address with ID " + address.getId());
    }
  }

  //Currently only deleting by ID
  @DeleteMapping("/addresses")
  @ResponseStatus(HttpStatus.OK)
  public void removeAddress(@RequestBody Address address, HttpServletResponse response) {
    System.out.println("AddressController.removeAddress(" + address + ")");
    try {
      addressService.removeAddress(address);
    } catch (NotInListException e) {
      throw new AddressNotFoundException("Attempted to delete an address not in the list of addresses.");
    }
  }

  @DeleteMapping("/addresses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void removeAddressById(@PathVariable int id, HttpServletResponse response) {
    System.out.println("AddressController.removeAddressById(" + id + ")");
    addressService.removeAddressById(id);

  }

  @ExceptionHandler(AddressNotFoundException.class)
  @ResponseStatus(
    value = HttpStatus.NOT_ACCEPTABLE,
    reason = "Address not found")
  public void addressNotFoundFailure() {
    System.out.println("Handling error for address.");
  }

  @ExceptionHandler(InvalidAddressException.class)
  @ResponseStatus(
    value = HttpStatus.NOT_IMPLEMENTED,
    reason = "Cannot create/update this address")
  public void addressCreationFailure() {
    System.out.println("Handling error for address.");
  }

}


