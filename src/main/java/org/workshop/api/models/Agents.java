package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Agents {
    private Integer count;
    private List<Agent> agent;
}
