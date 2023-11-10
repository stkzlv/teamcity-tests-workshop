package org.workshop.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildType {
    private String id;
    private String name;
    private Project project;
    private String projectName;
    private String projectId;
    private String href;
    private String webUrl;
    private Properties parameters;
    private Steps steps;
}
