package ui;

import org.testng.annotations.Test;
import org.workshop.ui.enums.CreateProjectMenu;
import org.workshop.ui.pages.admin.CreateProjectPage;

public class BuildConfigurationTest extends BaseUiTest {
    @Test
    public void buildConfigurationTest() {
        asAuthorisedUser();

        new CreateProjectPage()
                .open(CreateProjectMenu.CREATE_FROM_URL)
                .createProjectFromRepository(
                        testData.getVcsRoot().getProperties().getProperty("url").getValue(),
                        "", "");
    }
}
