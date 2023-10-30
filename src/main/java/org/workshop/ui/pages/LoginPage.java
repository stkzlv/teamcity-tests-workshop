package org.workshop.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class LoginPage extends Page {
    public SelenideElement inputUsername = element("input[id='username']");
    public SelenideElement inputPassword = element("input[id='password']");
    public SelenideElement inputSubmitLogin = element("input[class$='loginButton']");

    @Override
    public LoginPage open() {
        Selenide.open("/login.html");
        return new LoginPage();
    }

    public ProjectsPage login(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        return new ProjectsPage();
    }
}
