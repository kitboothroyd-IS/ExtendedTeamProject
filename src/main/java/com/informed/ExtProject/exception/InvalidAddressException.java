package com.informed.ExtProject.exception;

public class InvalidAddressException extends IllegalArgumentException{

  public InvalidAddressException() {
  }

  public InvalidAddressException(String s) {
    super(s);
  }

  public InvalidAddressException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidAddressException(Throwable cause) {
    super(cause);
  }
}
