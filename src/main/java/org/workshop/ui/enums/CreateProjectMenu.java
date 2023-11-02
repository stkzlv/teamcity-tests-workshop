package org.workshop.ui.enums;

public enum CreateProjectMenu {
    CREATE_FROM_URL("createProjectMenu#createFromUrl");

    private final String urlParameter;

    // Constructor
    CreateProjectMenu(String urlParameter) {
        this.urlParameter = urlParameter;
    }

    public String getUrlParameter() {
        return urlParameter;
    }
}
