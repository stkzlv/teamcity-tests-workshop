package org.workshop.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String id;
    private String name;
    private String parentProjectId;
    private Boolean virtual;
    private String href;
    private String webUrl;
    private Project parentProject;
    private BuildTypes buildTypes;
    private BuildTypes templates;
    private Properties parameters;
    private VcsRoots vcsRoots;
    private ProjectFeatures projectFeatures;
    private Projects projects;
    private String description;
}
