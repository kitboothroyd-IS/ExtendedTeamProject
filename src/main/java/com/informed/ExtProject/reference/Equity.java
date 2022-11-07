package com.informed.ExtProject.reference;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="equities")
public class Equity extends RefData{

    public Equity() {

    }

    public Equity(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public String toString() {
        return "Equity{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", symbol='" + super.getSymbol() + '\'' +
                '}';
    }
}
