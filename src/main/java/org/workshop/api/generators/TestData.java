package org.workshop.api.generators;

import lombok.Builder;
import lombok.Data;
import org.workshop.api.models.NewProjectDescription;

@Data
@Builder
public class TestData {
    private NewProjectDescription newProjectDescription;
}
