package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.*;
import org.workshop.api.requests.UncheckedRequests;

public class AgentsRequest {
    private final org.workshop.api.requests.uncheckedRequests.AgentsRequest agentsRequest = new org.workshop.api.requests.uncheckedRequests.AgentsRequest();

    public Agents getAll(String filters) {
        return agentsRequest.getAll(filters)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Agents.class);
    }

    public Boolean authorize(User user, String agentLocator, EnabledInfo enabledInfo) {
        return agentsRequest.authorize(user, agentLocator, enabledInfo)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().as(Boolean.class);
    }

    public void authorizeAgent(User user) {
        Agent firstAgent = getAll("?locator=authorized:any").getAgent().get(0);
        if (firstAgent.getAuthorized()== null || !firstAgent.getAuthorized()) {
            authorize(user, "id:" + firstAgent.getTypeId().toString(),
                    EnabledInfo.builder().comment(Comment.builder().text("").build()).status(true).build());
        }
    }
}
