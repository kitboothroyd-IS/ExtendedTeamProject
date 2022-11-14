package com.informed.ExtProject.controller.domain;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.exception.FailedCreationException;
import com.informed.ExtProject.exception.FailedDeletionException;
import com.informed.ExtProject.exception.ObjectNotFoundException;
import com.informed.ExtProject.server.domain.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
      throw new ObjectNotFoundException("Could not find any addresses");
    } else {
      System.out.println("AddressController.getAddresses()");
      return result;
    }

  }

  @GetMapping("/addresses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Address getAddressById(@PathVariable int id) {
    Optional<Address> result = addressService.getAddressById(id);
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new ObjectNotFoundException("Could not find address with ID" + result);
    }
  }


  @PostMapping("/addresses")
  @ResponseStatus(HttpStatus.CREATED)
  public void addAddress(@RequestBody Address address) {
    try {
      addressService.addAddress(address);
    } catch (FailedCreationException e) {
      throw new FailedCreationException("Failed to create an address");
    }
  }


  @PutMapping("/addresses")
  @ResponseStatus(HttpStatus.OK)
  public void updateAddress(@RequestBody Address address) {
    Optional<Address> addressResult = addressService.getAddressById(address.getId());
    if (addressResult.isPresent()) {
      try {
        System.out.println("AddressController.updateAddress with ID " + address.getId() + "(" + address + ")");
        addressService.updateAddress(address);
      } catch (IllegalArgumentException e) {
        throw new FailedCreationException("Failed to update address due to illegal argument.");
      }
    } else {
      throw new ObjectNotFoundException("Failed to find address with ID " + address.getId());
    }
  }

  //Currently only deleting by ID
  @DeleteMapping("/addresses")
  @ResponseStatus(HttpStatus.OK)
  public void removeAddress(@RequestBody Address address) {
    Optional<Address> optionalAddressById = addressService.getAddressById(address.getId());
    if (optionalAddressById.isPresent()){
      try {
        addressService.removeAddress(address);
        System.out.println("AddressController.removeAddress(" + address + ")");
      } catch (IllegalArgumentException e){
        throw new FailedDeletionException("Failed to delete address due to illegal argument");
      }
    } else {
      throw new ObjectNotFoundException("Failed to find address");
    }
  }

  @DeleteMapping("/addresses/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void removeAddressById(@PathVariable int id) {
    Optional<Address> optionalAddress = addressService.getAddressById(id);
    if (optionalAddress.isPresent()) {
      addressService.removeAddressById(id);
      System.out.println("AddressController.removeAddressById(" + id + ")");
    } else {
      throw new ObjectNotFoundException("Failed to remove address with ID:" + id + "does not exist");
    }
  }

  @ExceptionHandler(ObjectNotFoundException.class)
  @ResponseStatus(
    value = HttpStatus.NOT_ACCEPTABLE,
    reason = "Address not found")
  public void ObjectNotFoundException() {
    System.out.println("Handling error for address.");
  }

  @ExceptionHandler(FailedCreationException.class)
  @ResponseStatus(
    value = HttpStatus.NOT_IMPLEMENTED,
    reason = "Cannot create/update this address")
  public void FailedCreationException() {
    System.out.println("Handling error for address.");
  }

}


