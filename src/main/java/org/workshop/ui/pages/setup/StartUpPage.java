package org.workshop.ui.pages.setup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.workshop.api.generators.TestDataGenerator;
import org.workshop.api.requests.checkedRequests.UserRequest;
import org.workshop.ui.pages.LoginPage;
import org.workshop.ui.pages.Page;

import java.io.File;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.element;

public class StartUpPage extends Page {
    private SelenideElement acceptLicense = element("input[id='accept']");
    private SelenideElement restoreFromBackupButton = element("input[id='restoreButton']");
    private SelenideElement backFileUploaded = element("input[name='backupFile']");

    public StartUpPage open() {
        Selenide.open("/");
        return this;
    }

    public StartUpPage setupTeamCityServer() {
        proceedButton.click();
        waitUntilPageIsLoaded();
        proceedButton.click();
        waitUntilPageIsLoaded();
        acceptLicense.shouldBe(Condition.enabled, Duration.ofMinutes(3));
        acceptLicense.scrollTo();
        acceptLicense.click();
        submitButton.click();
        return this;
    }
}
