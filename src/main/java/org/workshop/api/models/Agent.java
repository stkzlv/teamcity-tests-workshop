package org.workshop.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
    private Integer id;
    private String name;
    private Integer typeId;
    private String locator;
    private String href;
    private String webUrl;
    private Boolean authorized;
}
