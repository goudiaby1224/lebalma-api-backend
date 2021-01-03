package com.sn.lde.ngy.model;

public enum Role {

    AGENT("AGENT"), EMPLOYE("EMPLOYE"), SOUS_ADMIN("SOUS_ADMIN");

    private String value;

    Role(String value) {
        this.value = value;
    }



    public String getValue() {
        return value;
    }



    void setValue(String value) {
        this.value = value;
    }



    public static Role fromValue(String value) {
        for (Role role : values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are ");
    }
}
