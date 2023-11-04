package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.workshop.api.models.*;

import java.util.Objects;

public class AgentsRequest {
    private final org.workshop.api.requests.uncheckedRequests.AgentsRequest agentsRequest = new org.workshop.api.requests.uncheckedRequests.AgentsRequest();

    public Agents getAll(String filters) {
        return agentsRequest.getAll(filters)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Agents.class);
    }

    public String authorize(String agentLocator) {
        return agentsRequest.authorize(agentLocator)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
    }

    public void authorizeAgent() {
        Agent firstAgent = getAll("?locator=authorized:any").getAgent().get(0);
        if (firstAgent.getAuthorized()== null || !firstAgent.getAuthorized()) {
            String result = authorize("id:" + firstAgent.getTypeId().toString());
            Assertions.assertThat(Objects.equals(result, "true"));
        }
    }
}
