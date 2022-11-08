package com.informed.ExtProject.controller.domain;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.server.domain.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("trader")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> getAddresses() {
        System.out.println("AddressController.getAddresses()");
        return addressService.getAllAddresses();
    }

    @GetMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddressById(@PathVariable int id, HttpServletResponse response) {
        System.out.println("AddressController.getId()");
        return addressService.getAddressById(id, response);
    }

    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody Address address) {
        System.out.println("AddressController.addAddress(" + address + ")");
        addressService.addAddress(address);
    }

    //Currently only deleting by ID
    @DeleteMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public void removeAddress(@RequestBody Address address, HttpServletResponse response) {
        System.out.println("AddressController.removeAddress(" + address + ")");
        addressService.removeAddress(address, response);
    }

    @DeleteMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeAddressById(@PathVariable int id, HttpServletResponse response) {
        System.out.println("AddressController.removeAddressById(" + id + ")");
        addressService.removeAddressById(id, response);

    }



}


