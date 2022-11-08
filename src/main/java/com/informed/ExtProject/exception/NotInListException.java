package com.informed.ExtProject.exception;

import java.util.NoSuchElementException;

public class NotInListException extends NoSuchElementException {
    public NotInListException(String idString) {
        super("The " + idString + " provided does not exist in the " + idString + " list.");
    }

}
