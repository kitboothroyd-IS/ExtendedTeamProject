package com.informed.ExtProject.reference;

public class Exchange extends RefData{

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
