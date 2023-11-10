package org.workshop.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildTypes {
    private Integer count;
    private String href;
    private String nextHref;
    private String prevHref;
    private List<BuildType> buildType;
}
