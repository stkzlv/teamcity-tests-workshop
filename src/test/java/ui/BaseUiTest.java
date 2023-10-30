package ui;

import api.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import okhttp3.Request;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;
import org.workshop.api.Config;
import org.workshop.api.generators.RandomData;
import org.workshop.api.models.User;
import org.workshop.api.requests.checkedRequests.AuthRequest;
import org.workshop.api.requests.checkedRequests.UserRequest;
import org.workshop.ui.pages.LoginPage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseUiTest extends BaseTest {
    private static final String TCSESSIONID = "TCSESSIONID";

    public void asAuthorisedUser() {
        var user = User.builder().username(new RandomData().getString()).password(new RandomData().getString()).build();
        new UserRequest(user).create(user);
        new LoginPage().login(user.getUsername(), user.getPassword());
    }


    @BeforeSuite
    public void beforeAll() {
        Configuration.baseUrl = Config.getProperty("baseUiUrl");
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";
        Configuration.browser = "firefox";

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableLog", true);

        FirefoxOptions capabilities = new FirefoxOptions();
        Configuration.browserCapabilities = capabilities;
        Configuration.browserCapabilities.setCapability("selenoid:options", options);
    }
}
