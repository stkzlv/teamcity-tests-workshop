package org.workshop.api.enums;

import lombok.Getter;

@Getter
public enum BuildStatus {
    SUCCESS("SUCCESS");
    private final String value;

    BuildStatus(String value) {
        this.value = value;
    }

}
