package com.overdaily.Overdaily.exceptions.Hero;

public class NonExistentRole extends RuntimeException {
    public NonExistentRole(String role) {
        super("Non existent role: " + role );
    }
}
