package com.informed.ExtProject.reference;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.exception.NoSymbolException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class RefData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", initialValue = 1)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String symbol;

    public RefData() {

    }
    public RefData(String name, String symbol){
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

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefData refData)) return false;
        return getId() == refData.getId();
    }

    public int hashCode() {
        return getId() + getSymbol().hashCode();
    }

}


