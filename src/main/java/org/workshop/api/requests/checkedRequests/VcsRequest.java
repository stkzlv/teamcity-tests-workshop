package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.VCSRoot;

public class VcsRequest implements CheckedRequestInterface {
    @Override
    public VCSRoot create(Object dto) {
        return unchecked.vcsRequest.create(dto)
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
    public void delete(String id) {
        unchecked.vcsRequest.delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK);
    }
}
