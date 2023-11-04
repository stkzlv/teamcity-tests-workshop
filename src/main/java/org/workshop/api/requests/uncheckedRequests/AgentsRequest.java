package org.workshop.api.requests.uncheckedRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.workshop.api.models.EnabledInfo;
import org.workshop.api.models.User;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class AgentsRequest {
    private static final String AGENTS_ENDPOINT = "/app/rest/agents";

    public Response getAll(String filters) {
        return given().spec(Specifications.spec().getAdminReqSpec(ContentType.JSON)).get(AGENTS_ENDPOINT + filters);
    }

    public Response authorize(String agentLocator) {
        return given().spec(Specifications.spec().getAdminReqSpec(ContentType.TEXT)).body("true").put(AGENTS_ENDPOINT + "/" + agentLocator + "/authorized");
    }
}
