package org.workshop.api.enums;

import lombok.Getter;

@Getter
public enum AuthMethod {
    ANONYMOUS("ANONYMOUS");

    private final String value;

    AuthMethod(String value) {
        this.value = value;
    }

}
