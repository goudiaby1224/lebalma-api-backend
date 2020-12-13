package com.sn.lde.ngy.model;

public enum Types {

    EMPLOYEUR("EMPLOYEUR"), MARCHANT("MARCHANT");

    private String value;

    Types(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Types fromValue(String value) {
        for (Types type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are ");
    }
}
