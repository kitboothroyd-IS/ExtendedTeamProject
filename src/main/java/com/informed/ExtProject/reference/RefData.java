package com.informed.ExtProject.reference;

import com.informed.ExtProject.exception.NoSymbolException;

public abstract class RefData {
    private int id;
    private String name;
    private String symbol;

    public RefData(int id, String name, String symbol){
        this.id = id;
        this.name = name;
        setSymbol(symbol);
    }

    private void setSymbol(String symbol) {
        if (symbol.isBlank()) {
            throw new NoSymbolException();
        }
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
