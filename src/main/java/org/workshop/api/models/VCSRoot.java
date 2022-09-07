package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VCSRoot {
    private String id;
    private String name;
    private String vcsName;
    private Project project;
    private Properties properties;
}
