package org.workshop.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.element;

public abstract class Page {
    private SelenideElement refreshIcon = element("span[class*='icon-refresh']");
    protected SelenideElement proceedButton = element("input[value='Proceed']");
    protected SelenideElement submitButton = element("input[type='submit']");

    protected SelenideElement cancelButton = element("input[id='cancelButton']");

    private SelenideElement header = element("h1[id='header']");

    public Page waitUntilPageIsLoaded() {
        refreshIcon.shouldBe(Condition.not(Condition.be(Condition.visible)), Duration.ofMinutes(3));
        return this;
    }

    public SelenideElement getHeader() {
        return header;
    }
}
