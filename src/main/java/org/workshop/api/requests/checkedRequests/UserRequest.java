package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.requests.UncheckedRequests;

public class UserRequest implements CrudInterface {
    private User user;
    public UserRequest(User user) {
        this.user = user;
    }

    @Override
    public Object create(Object dto) {
        return new UncheckedRequests(user).userRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(User.class);
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
    public Object delete(String username) {
        return new UncheckedRequests(user).userRequest.delete(username)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT)
                .extract().response().asString();
    }
}
