package com.informed.ExtProject.exception;

public class NoSymbolException extends IllegalArgumentException {

    public NoSymbolException() {
        super("You must include a symbol.");
    }
}
