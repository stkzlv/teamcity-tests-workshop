package org.workshop.api.enums;

public enum VcsNameType {
    JETBRAINS_GIT("jetbrains.git");

    private final String value;
    VcsNameType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
