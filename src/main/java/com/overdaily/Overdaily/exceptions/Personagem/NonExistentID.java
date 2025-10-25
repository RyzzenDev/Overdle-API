package com.overdaily.Overdaily.exceptions.Personagem;

public class NonExistentID extends RuntimeException {
  public NonExistentID(int id) {
    super("The specified ID"+ id +"does not exist.");
  }
}
