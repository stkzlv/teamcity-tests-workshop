package org.workshop.api.enums;

import lombok.Getter;

@Getter
public enum BuildState {
    FINISHED("finished");

    private final String value;

    BuildState(String value) {
        this.value = value;
    }

}
