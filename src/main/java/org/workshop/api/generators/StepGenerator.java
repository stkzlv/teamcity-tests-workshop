package org.workshop.api.generators;

import org.workshop.api.enums.StepType;
import org.workshop.api.models.Step;
import org.workshop.api.models.Steps;

import java.util.Arrays;
import java.util.Collections;

public class StepGenerator {
    private final RandomData randomData = new RandomData();

    public Steps getBasicStep(StepType stepType, String stepContent) {
        return Steps.builder().step(Collections.singletonList(Step.builder()
                        .name(randomData.getString())
                        .type(stepType.getValue())
                        .properties(new PropertiesGenerator().getBasicStepProperties(stepContent))
                        .build()))
                .build();
    }
}
