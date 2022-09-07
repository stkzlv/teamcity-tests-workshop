package org.workshop.api.generators;

import org.workshop.api.enums.VcsNameType;
import org.workshop.api.models.*;

public class TestDataGenerator {
    private final RandomData randomData = new RandomData();
    private final PropertiesGenerator propertiesGenerator = new PropertiesGenerator();

    public TestData generate() {
        var project = NewProjectDescription.builder()
                .id(randomData.getString())
                .name(randomData.getString())
                .parentProject(
                        ParentProject.builder()
                                .locator("_Root")
                                .build()
                )
                .copyAllAssociatedSettings(randomData.getBoolean())
                .build();

        var vcsRoot = VCSRoot.builder()
                .id(randomData.getString())
                .name(randomData.getString())
                .vcsName(VcsNameType.JETBRAINS_GIT.getValue())
                .project(Project.builder().id(project.getId()).build())
                .properties(propertiesGenerator.getBasicVcsProperties())
                .build();

        var buildType = BuildType.builder()
                .id(randomData.getString())
                .name(randomData.getString())
                .project(Project.builder().id(project.getId()).build())
                .build();

        return TestData.builder()
                .newProjectDescription(project)
                .vcsRoot(vcsRoot)
                .buildType(buildType)
                .build();
    }
}
