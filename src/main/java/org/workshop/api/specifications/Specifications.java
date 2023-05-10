package org.workshop.api.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.workshop.api.requests.checkedRequests.CheckedRequests;

public class Specifications {
    private static final String CSRF_TOKEN = "X-TC-CSRF-Token";

    public RequestSpecification reqSpec() {
        var csrfToken = new CheckedRequests().authRequest.getCsrfToken();

        var requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.addHeader(CSRF_TOKEN, csrfToken);

        return requestSpecBuilder.build();
    }
}
