package api;

import org.testng.annotations.Test;
import org.workshop.api.enums.BuildStatus;
import org.workshop.api.enums.StepType;
import org.workshop.api.generators.StepGenerator;
import org.workshop.api.models.Build;

public class BuildConfigurationTest extends BaseApiTest {
    @Test
    public void buildConfigurationTest() {
        checked.userRequest.create(testData.getUser());
        testData.getBuildType().setSteps(
                new StepGenerator().getBasicStep(StepType.SIMPLE_RUNNER, "echo \"Hello, world!\""));

        checked.projectRequest.create(testData.getNewProjectDescription());
        checked.vcsRequest.create(testData.getVcsRoot());
        checked.buildTypeRequest.create(testData.getBuildType());

        var build = checked.buildRequest.create(Build.builder().buildType(testData.getBuildType()).build());
        checked.buildRequest.waitUntilFinished(build.getId());
        build = checked.buildRequest.get(build.getId().toString());

        softy.assertThat(build.getStatus()).isEqualTo(BuildStatus.SUCCESS.getValue());
    }
}
