package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class BuildTypeRequest implements CrudInterface {
    private User user;
    private static final String BUILD_TYPES_ENDPOINT = "/app/rest/buildTypes";

    public BuildTypeRequest(User user) {
        this.user = user;
    }

    @Override
    public Response create(Object dto) {
        return given().spec(Specifications.spec().getUserSpec(user)).body(dto).post(BUILD_TYPES_ENDPOINT);
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
        return given().spec(Specifications.spec().getUserSpec(user)).delete(BUILD_TYPES_ENDPOINT + "/id:" + id);
    }
}
