package org.workshop.api.requests.uncheckedRequests;

import io.restassured.response.Response;
import org.workshop.api.models.EnabledInfo;
import org.workshop.api.models.User;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class AgentsRequest {
    private static final String AGENTS_ENDPOINT = "/app/rest/agents";

    public Response getAll(String filters) {
        return given().spec(Specifications.spec().getAdminReqSpec()).get(AGENTS_ENDPOINT + filters);
    }

    public Response authorize(User user, String agentLocator, EnabledInfo enabledInfo) {
        return given().spec(Specifications.spec().getUserSpec(user)).body(enabledInfo).put(AGENTS_ENDPOINT + "/" + agentLocator + "/authorized");
    }
}
