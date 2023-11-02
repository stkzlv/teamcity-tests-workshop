package org.workshop.ui.pages.admin;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.workshop.ui.enums.CreateProjectMenu;
import org.workshop.ui.pages.Page;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class CreateProjectPage extends Page {
    private SelenideElement urlInput = element("input[id='url']");
    private SelenideElement usernameInput = element("input[id='username']");
    private SelenideElement passwordInput = element("input[id='password']");

    public CreateProjectPage open(CreateProjectMenu showMode) {
        Selenide.open("/admin/createObjectMenu.html?projectId=_Root&showMode=" + showMode.getUrlParameter());
        return new CreateProjectPage();
    }

    public void createProjectFromRepository(String url, String username, String password) {
        urlInput.sendKeys(url);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        proceedButton.click();
        proceedButton.click();
    }
}
