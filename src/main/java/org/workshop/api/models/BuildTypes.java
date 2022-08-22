package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BuildTypes {
    private Integer count;
    private String href;
    private String nextHref;
    private String prevHref;
    private List<BuildType> buildType;
}
