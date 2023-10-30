package org.workshop.ui.pages.admin;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.workshop.ui.pages.Page;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class CreateProjectFromUrlPage extends Page {
    private SelenideElement projectNameInput = element("input[id='projectName']");
    private SelenideElement buildTypeNameInput = element("input[id='buildTypeName']");

    @Override
    public CreateProjectFromUrlPage open() {
        Selenide.open("/admin/objectSetup.html");
        return new CreateProjectFromUrlPage();
    }
}
