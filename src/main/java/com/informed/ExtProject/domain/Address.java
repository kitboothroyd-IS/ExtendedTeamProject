package com.informed.ExtProject.domain;

import com.informed.ExtProject.server.AddressService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String line1;
    private String line2;
    private String line3;
    @NotNull
    private String city;
    @NotNull
    private String county;
    @NotNull
    private String postcode;

    public Address() {

    }

    public Address(String line1, String line2, String line3, String city, String county, String postcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
