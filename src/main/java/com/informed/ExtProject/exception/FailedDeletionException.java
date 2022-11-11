package com.informed.ExtProject.exception;

public class FailedDeletionException extends IllegalArgumentException{

  public FailedDeletionException() {
  }

  public FailedDeletionException(String s) {
    super(s);
  }

  public FailedDeletionException(String message, Throwable cause) {
    super(message, cause);
  }

  public FailedDeletionException(Throwable cause) {
    super(cause);
  }
}
