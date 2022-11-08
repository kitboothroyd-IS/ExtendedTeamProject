package com.informed.ExtProject.exception;

import java.util.NoSuchElementException;

public class AddressNotFoundException extends NoSuchElementException {
  public AddressNotFoundException(String s) {
    super(s);
  }

  public AddressNotFoundException() {
  }

  public AddressNotFoundException(String s, Throwable cause) {
    super(s, cause);
  }

  public AddressNotFoundException(Throwable cause) {
    super(cause);
  }
}

