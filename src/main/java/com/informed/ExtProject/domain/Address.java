package com.informed.ExtProject.domain;

import com.informed.ExtProject.server.AddressService;

public class Address {
    private static int newId = 1;

    private int id;
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String county;
    private String postcode;

    public Address(String line1, String line2, String line3, String city, String county, String postcode) {
        this.id = newId;
        newId++;
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
