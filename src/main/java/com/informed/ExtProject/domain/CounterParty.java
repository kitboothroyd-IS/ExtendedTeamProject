package com.informed.ExtProject.domain;

public class CounterParty {

    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Address address;

    public CounterParty(String name, String phoneNumber, String emailAddress, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
