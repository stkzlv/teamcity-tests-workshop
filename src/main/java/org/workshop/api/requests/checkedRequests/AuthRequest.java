package org.workshop.api.requests.checkedRequests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

public class AuthRequest {
    private static final String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";

    public String getCsrfToken() {
        return RestAssured.get(AUTHENTICATION_ENDPOINT)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }
}
