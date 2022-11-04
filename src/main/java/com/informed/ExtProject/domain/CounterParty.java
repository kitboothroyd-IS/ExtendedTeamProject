package com.informed.ExtProject.domain;

public class CounterParty {
    private static int newId = 1;

    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Address address;

    public CounterParty(String name, String phoneNumber, String emailAddress, Address address) {
        this.id = newId;
        newId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
