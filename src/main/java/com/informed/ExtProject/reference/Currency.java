package com.informed.ExtProject.reference;

public class Currency extends RefData{

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
