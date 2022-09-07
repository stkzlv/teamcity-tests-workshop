package org.workshop.api.enums;

public enum BuildStatus {
    SUCCESS("SUCCESS");
    private final String value;

    BuildStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
