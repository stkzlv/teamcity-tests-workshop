package org.workshop.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Build {
    private Long id;
    private String buildTypeId;
    private BuildType buildType;
    private String state;
    private String status;
}
