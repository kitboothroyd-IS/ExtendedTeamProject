package com.informed.ExtProject.exception;

public class AddressDeletionException extends IllegalArgumentException{

  public AddressDeletionException() {
  }

  public AddressDeletionException(String s) {
    super(s);
  }

  public AddressDeletionException(String message, Throwable cause) {
    super(message, cause);
  }

  public AddressDeletionException(Throwable cause) {
    super(cause);
  }
}
