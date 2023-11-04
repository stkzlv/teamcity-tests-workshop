package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Agent {
    private Integer id;
    private String name;
    private Integer typeId;
    private String locator;
    private Boolean connected;
    private Boolean enabled;
    private Boolean authorized;
}
