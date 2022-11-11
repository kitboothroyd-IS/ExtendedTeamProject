package com.informed.ExtProject.exception;

public class FailedCreationException extends IllegalArgumentException{

  public FailedCreationException() {
  }

  public FailedCreationException(String s) {
    super(s);
  }

  public FailedCreationException(String message, Throwable cause) {
    super(message, cause);
  }

  public FailedCreationException(Throwable cause) {
    super(cause);
  }
}
