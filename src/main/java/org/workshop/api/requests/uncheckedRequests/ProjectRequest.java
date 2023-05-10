package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProjectRequest implements UncheckedRequestInterface {
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";

    @Override
    public Response create(Object project) {
        return given().spec(spec.reqSpec()).body(project).post(PROJECT_ENDPOINT);
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
        return given().spec(spec.reqSpec()).delete(PROJECT_ENDPOINT + "/id:" + id);
    }
}
