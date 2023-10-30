package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.requests.UncheckedRequests;

public class BuildTypeRequest implements CrudInterface {
    private User user;
    public BuildTypeRequest(User user) {
        this.user = user;
    }

    @Override
    public BuildType create(Object dto) {
        return new UncheckedRequests(user).buildTypeRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(BuildType.class);
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
    public String delete(String id) {
        return new UncheckedRequests(user).buildTypeRequest.delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }
}
