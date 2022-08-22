package org.workshop.api.generators;

import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.ParentProject;

public class TestDataGenerator {
    private final RandomData randomData = new RandomData();

    public TestData generate() {
        return TestData.builder()
                .newProjectDescription(
                        NewProjectDescription.builder()
                                .id(randomData.getString())
                                .name(randomData.getString())
                                .parentProject(
                                        ParentProject.builder()
                                                .locator("_Root")
                                                .build()
                                )
                                .copyAllAssociatedSettings(randomData.getBoolean())
                                .build())
                .build();
    }
}
