package com.informed.ExtProject.exception;

import java.util.NoSuchElementException;

public class ObjectNotFoundException extends NoSuchElementException {
  public ObjectNotFoundException(String s) {
    super(s);
  }

  public ObjectNotFoundException() {
  }

  public ObjectNotFoundException(String s, Throwable cause) {
    super(s, cause);
  }

  public ObjectNotFoundException(Throwable cause) {
    super(cause);
  }
}

