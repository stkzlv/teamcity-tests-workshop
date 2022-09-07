package org.workshop.api.enums;

public enum AuthMethod {
    ANONYMOUS("ANONYMOUS");

    private String value;

    AuthMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
