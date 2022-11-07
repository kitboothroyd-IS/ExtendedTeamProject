package com.informed.ExtProject.reference;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency extends RefData{

    public Currency() {

    }

    public Currency(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", symbol='" + super.getSymbol() + '\'' +
                '}';
    }
}
