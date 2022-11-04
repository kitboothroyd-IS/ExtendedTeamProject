package com.informed.ExtProject.reference;

public class Equity extends RefData{
    private static int newId = 1;

    public Equity(String name, String symbol) {
        super(newId, name, symbol);
        newId++;
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
