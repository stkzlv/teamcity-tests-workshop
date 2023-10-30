package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class VcsRequest  implements CrudInterface {
    private User user;
    private static final String VCS_ROOTS_ENDPOINT = "/app/rest/vcs-roots";

    public VcsRequest(User user) {
        this.user = user;
    }

    @Override
    public Response create(Object dto) {
        return given().spec(Specifications.spec().getUserSpec(user)).body(dto).post(VCS_ROOTS_ENDPOINT);
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
        return given().spec(Specifications.spec().getUserSpec(user)).delete(VCS_ROOTS_ENDPOINT + "/id:" + id);
    }
}
