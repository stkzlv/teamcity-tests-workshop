package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuildRequest implements UncheckedRequestInterface {
    private static final String BUILD_QUEUE_ENDPOINT = "/app/rest/buildQueue";
    private static final String BUILDS_ENDPOINT = "/app/rest/builds";

    @Override
    public Response create(Object dto) {
        return given().spec(spec.reqSpec()).body(dto).post(BUILD_QUEUE_ENDPOINT);
    }

    @Override
    public Response get(String id) {
        return given().spec(spec.reqSpec()).get(BUILDS_ENDPOINT + "/id:" + id);
    }

    @Override
    public Response update(Object dto) {
        return null;
    }

    @Override
    public Response delete(String id) {
        return null;
    }
}
