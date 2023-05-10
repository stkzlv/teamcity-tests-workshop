package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.Project;

public class ProjectRequest implements CheckedRequestInterface {
    @Override
    public Project create(Object dto) {
        return unchecked.projectRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Project.class);
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
        unchecked.projectRequest.delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
