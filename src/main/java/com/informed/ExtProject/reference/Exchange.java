package com.informed.ExtProject.reference;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "exchanges")
public class Exchange extends RefData{

    public Exchange() {

    }

    public Exchange(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", symbol='" + super.getSymbol() + '\'' +
                '}';
    }
}
