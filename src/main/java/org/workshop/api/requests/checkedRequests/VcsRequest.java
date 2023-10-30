package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.User;
import org.workshop.api.models.VCSRoot;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.requests.UncheckedRequests;

public class VcsRequest implements CrudInterface {
    private User user;
    public VcsRequest(User user) {
        this.user = user;
    }

    @Override
    public VCSRoot create(Object dto) {
        return new UncheckedRequests(user).vcsRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(VCSRoot.class);
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
        return new UncheckedRequests(user).vcsRequest.delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }
}
