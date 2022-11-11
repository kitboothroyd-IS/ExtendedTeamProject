package com.informed.ExtProject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "counterParties")
public class CounterParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    private String phoneNumber;
    private String emailAddress;
    @NotNull
    @ManyToOne()
    @JoinColumn(name="addressId", nullable = false)
    private Address address;

    public CounterParty() {

    }
    public CounterParty(String name, String phoneNumber, String emailAddress, Address address) {
        this.name = name;
        this.address = address;

        // Check that at least the phone number or the email address are valid
        if ((phoneNumber == null || phoneNumber.length() < 7 || phoneNumber.length() > 15) &&
                (emailAddress == null || emailAddress.isEmpty())) {
            throw new IllegalArgumentException("You must provide a valid phone number or email address.");
        } else {
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "CounterParty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address=" + address +
                '}';
    }
}
