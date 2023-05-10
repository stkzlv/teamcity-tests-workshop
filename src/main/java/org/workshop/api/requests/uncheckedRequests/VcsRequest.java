package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class VcsRequest implements UncheckedRequestInterface {
    private static final String VCS_ROOTS_ENDPOINT = "/app/rest/vcs-roots";

    @Override
    public Response create(Object dto) {
        return given().spec(spec.reqSpec()).body(dto).post(VCS_ROOTS_ENDPOINT);
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
        return given().spec(spec.reqSpec()).delete(VCS_ROOTS_ENDPOINT + "/id:" + id);
    }
}
