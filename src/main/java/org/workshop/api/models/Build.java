package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Build {
    private Long id;
    private String buildTypeId;
    private BuildType buildType;
    private String state;
    private String status;
}
