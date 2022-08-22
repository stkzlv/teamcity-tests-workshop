package api;

import org.testng.annotations.Test;
import org.workshop.api.requests.CheckedRequest;

public class BuildConfigurationTest extends BaseTest {
    @Test
    public void buildConfigurationTest() {
        var testData = testDataGenerator.generate();

        var createdProject = new CheckedRequest().createProject(testData.getNewProjectDescription());

        softy.assertThat(createdProject.getId()).isEqualTo(testData.getNewProjectDescription().getId());
    }
}
