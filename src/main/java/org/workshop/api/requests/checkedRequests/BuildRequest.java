package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.enums.BuildState;
import org.workshop.api.models.Build;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.requests.UncheckedRequests;

public class BuildRequest implements CrudInterface {
    private User user;
    private static final long TIMEOUT = 60_000;

    public BuildRequest(User user) {
        this.user = user;
    }

    @Override
    public Build create(Object dto) {
        return new UncheckedRequests(user).buildRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);

    }

    @Override
    public Build get(String id) {
        return new UncheckedRequests(user).buildRequest.get(id)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object delete(String id) {
        return null;
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
