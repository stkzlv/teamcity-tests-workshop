package org.workshop.api.requests.uncheckedRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class UserRequest implements CrudInterface {
    private User user;
    private static final String USER_ENDPOINT = "/app/rest/users";

    public UserRequest(User user) {
        this.user = user;
    }

    @Override
    public Response create(Object user) {
        return given().spec(Specifications.spec().getAdminReqSpec(ContentType.JSON)).body(user).post( USER_ENDPOINT);
    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Response delete(String username) {
        return given().spec(Specifications.spec().getUserSpec(user)).delete(USER_ENDPOINT + "/username:" + username);
    }
}
