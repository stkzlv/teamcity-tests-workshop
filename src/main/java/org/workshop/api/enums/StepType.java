package org.workshop.api.enums;

public enum StepType {
    SIMPLE_RUNNER("simpleRunner");

    private String value;

    StepType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
