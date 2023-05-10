package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.BuildType;

public class BuildTypeRequest implements CheckedRequestInterface{
    @Override
    public BuildType create(Object dto) {
        return unchecked.buildTypeRequest.create(dto)
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
    public void delete(String id) {
        unchecked.buildTypeRequest.delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK);
    }
}
