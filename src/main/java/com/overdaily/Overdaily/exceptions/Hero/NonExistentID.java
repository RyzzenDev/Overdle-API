package com.overdaily.Overdaily.exceptions.Hero;

public class NonExistentID extends RuntimeException {
  public NonExistentID(int id) {
    super("The specified ID"+ id +"does not exist.");
  }
}
