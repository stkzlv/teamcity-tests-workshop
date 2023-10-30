package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class BuildRequest implements CrudInterface {
    private static final String BUILD_QUEUE_ENDPOINT = "/app/rest/buildQueue";
    private static final String BUILDS_ENDPOINT = "/app/rest/builds";

    private User user;

    public BuildRequest(User user) {
        this.user = user;
    }

    @Override
    public Response create(Object dto) {
        return given().spec(Specifications.spec().getUserSpec(user)).body(dto).post(BUILD_QUEUE_ENDPOINT);
    }

    @Override
    public Response get(String id) {
        return given().spec(Specifications.spec().getUserSpec(user)).get(BUILDS_ENDPOINT + "/id:" + id);
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
