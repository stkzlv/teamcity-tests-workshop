package org.workshop.ui.pages;

import com.codeborne.selenide.selector.ByAttribute;

public class Selectors {
    private static final String DATA_TEST_ATTRIBUTE = "data-test";
    public static ByAttribute byDataTest(String attributeValue) {
        return new ByAttribute(DATA_TEST_ATTRIBUTE, attributeValue);
    }
}
