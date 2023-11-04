package org.workshop.api.requests.checkedRequests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.workshop.api.Config;
import org.workshop.api.models.User;

public class AuthRequest {
    private User user;
    private static final String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";

    public AuthRequest(User user) {
        this.user = user;
    }

    public String getCsrfToken() {
        String url = "http://" + user.getUsername() + ":" + user.getPassword() + "@" + Config.getProperty("host");
        return RestAssured.get(url + AUTHENTICATION_ENDPOINT)
                .then().extract().response().asString();
    }

    public String getCookie(String name, User user) {
        var k = RestAssured.get(AUTHENTICATION_ENDPOINT)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().cookies();

        return k.get(name);
    }
}
