package com.informed.ExtProject.reference;

public class Equity extends RefData{

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
