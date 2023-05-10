package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuildTypeRequest implements UncheckedRequestInterface {
    private static final String BUILD_TYPES_ENDPOINT = "/app/rest/buildTypes";

    @Override
    public Response create(Object dto) {
        return given().spec(spec.reqSpec()).body(dto).post(BUILD_TYPES_ENDPOINT);
    }

    @Override
    public Response get(String id) {
        return null;
    }

    @Override
    public Response update(Object dto) {
        return null;
    }

    @Override
    public Response delete(String id) {
        return given().spec(spec.reqSpec()).delete(BUILD_TYPES_ENDPOINT + "/id:" + id);
    }
}
