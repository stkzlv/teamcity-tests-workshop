package org.workshop.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.elements;

public class ProjectsPage extends Page {
    private ElementsCollection subprojects = elements(Selectors.byDataTest("subproject"));

    public void chooseSubproject(String name) {
        subprojects.find(Condition.exactText(name)).click();
    }


    public Page open() {
        return null;
    }
}
