package org.workshop.api.generators;

import org.workshop.api.enums.VcsNameType;
import org.workshop.api.models.*;

import java.util.ArrayList;

public class TestDataGenerator {
    private final RandomData randomData = new RandomData();
    private final PropertiesGenerator propertiesGenerator = new PropertiesGenerator();

    public TestData generate() {
        var roles = new ArrayList<Role>();
        roles.add(Role.builder().roleId("SYSTEM_ADMIN").scope("g").build());

        var user = User.builder()
                .username(randomData.getString())
                .password(randomData.getString())
                .email(randomData.getString()+"@gmail.com")
                .roles(Roles.builder().role(roles).build())
                .build();

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
                .user(user)
                .newProjectDescription(project)
                .vcsRoot(vcsRoot)
                .buildType(buildType)
                .build();
    }
}
