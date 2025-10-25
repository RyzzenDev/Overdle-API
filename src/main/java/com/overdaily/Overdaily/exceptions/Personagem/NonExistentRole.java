package com.overdaily.Overdaily.exceptions.Personagem;

public class NonExistentRole extends RuntimeException {
    public NonExistentRole(String role) {
        super("Non existent role: " + role );
    }
}
