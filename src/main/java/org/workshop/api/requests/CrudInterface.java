package org.workshop.api.requests;

import io.restassured.response.Response;
import org.workshop.api.specifications.Specifications;

public interface CrudInterface {
    Object create(Object dto);

    Object get(String id);

    Object update(Object dto);

    Object delete(String id);
}
