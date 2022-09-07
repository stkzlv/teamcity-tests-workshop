package api;

import org.testng.annotations.Test;
import org.workshop.api.enums.BuildStatus;
import org.workshop.api.enums.StepType;
import org.workshop.api.generators.StepGenerator;
import org.workshop.api.models.Build;

public class BuildConfigurationTest extends BaseTest {
    @Test
    public void buildConfigurationTest() {
        testData.getBuildType().setSteps(
                new StepGenerator().getBasicStep(StepType.SIMPLE_RUNNER, "echo \"Hello, world!\""));

        checkedRequest.createProject(testData.getNewProjectDescription());
        checkedRequest.createVCS(testData.getVcsRoot());
        checkedRequest.createBuildConfiguration(testData.getBuildType());

        var build = checkedRequest.runBuildConfiguration(Build.builder().buildType(testData.getBuildType()).build());
        checkedRequest.waitUntilBuildFinished(build.getId());
        build = checkedRequest.getBuild(build.getId());

        softy.assertThat(build.getStatus()).isEqualTo(BuildStatus.SUCCESS.getValue());
    }
}
