package org.workshop.api.enums;

import lombok.Getter;

@Getter
public enum StepType {
    SIMPLE_RUNNER("simpleRunner");

    private final String value;

    StepType(String value) {
        this.value = value;
    }

}
