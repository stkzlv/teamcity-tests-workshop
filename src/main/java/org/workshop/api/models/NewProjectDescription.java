package org.workshop.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewProjectDescription {
    private ParentProject parentProject;
    private String name;
    private String id;
    private Boolean copyAllAssociatedSettings;
}
