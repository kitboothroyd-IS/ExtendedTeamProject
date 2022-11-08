package com.informed.ExtProject.exception;

public class AddressCreationException extends IllegalArgumentException{

  public AddressCreationException() {
  }

  public AddressCreationException(String s) {
    super(s);
  }

  public AddressCreationException(String message, Throwable cause) {
    super(message, cause);
  }

  public AddressCreationException(Throwable cause) {
    super(cause);
  }
}
