package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.enums.BuildState;
import org.workshop.api.models.Build;

public class BuildRequest implements CheckedRequestInterface {
    private static final long TIMEOUT = 60_000;

    @Override
    public Build create(Object dto) {
        return unchecked.buildRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);

    }

    @Override
    public Build get(String id) {
        return unchecked.buildRequest.get(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public void waitUntilFinished(Long id) {
        var startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < TIMEOUT) {
            var build = get(id.toString());
            if (build.getState() != null && build.getState().equals(BuildState.FINISHED.getValue())) {
                break;
            }
        }
    }
}
