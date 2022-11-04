package com.informed.ExtProject.reference;

public class Currency extends RefData{
    private static int newId = 1;

    public Currency(String name, String symbol) {
        super(newId, name, symbol);
        newId++;
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
