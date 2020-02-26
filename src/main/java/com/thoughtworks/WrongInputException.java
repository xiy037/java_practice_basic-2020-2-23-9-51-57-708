package com.thoughtworks;

import java.io.IOException;

public class WrongInputException extends IOException {
  public WrongInputException() {
    super("Wrong Input. Input Again!");
  }
}
