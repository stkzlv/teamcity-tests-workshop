package org.workshop.api.enums;

import lombok.Getter;

@Getter
public enum VcsNameType {
    JETBRAINS_GIT("jetbrains.git");

    private final String value;
    VcsNameType(String value) {
        this.value = value;
    }

}
