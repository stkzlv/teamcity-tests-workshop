package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class ProjectRequest  implements CrudInterface {
    private User user;
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";

    public ProjectRequest(User user) {
        this.user = user;
    }

    @Override
    public Response create(Object project) {
        return given().spec(Specifications.spec().getUserSpec(user)).body(project).post(PROJECT_ENDPOINT);
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
        return given().spec(Specifications.spec().getUserSpec(user)).delete(PROJECT_ENDPOINT + "/id:" + id);
    }
}
