package com.neighborhoodhelp.neighborhood_help.model;

public enum Role {
    RESIDENT("RESIDENT"),
    VOLUNTEER("VOLUNTEER"),
    ADMIN("ADMIN");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return this.roleName;
    }
}
