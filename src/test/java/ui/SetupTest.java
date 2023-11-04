package ui;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import org.workshop.ui.pages.setup.StartUpPage;

public class SetupTest extends BaseUiTest {
    @Test
    public void startUpTest() {
        new StartUpPage()
                .open()
                .setupTeamCityServer()
                .getHeader().shouldHave(Condition.text("Create Administrator Account"));
    }
}
