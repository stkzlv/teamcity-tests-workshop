package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;
import org.workshop.api.specifications.Specifications;

public interface UncheckedRequestInterface {
    public final Specifications spec = new Specifications();

    public Response create(Object dto);

    public Response get(String id);

    public Response update(Object dto);

    public Response delete(String id);
}
