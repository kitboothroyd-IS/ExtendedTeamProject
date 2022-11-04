package com.informed.ExtProject.reference;

public class Exchange extends RefData{
    private static int newId = 1;

    public Exchange(String name, String symbol) {
        super(newId, name, symbol);
        newId++;
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
