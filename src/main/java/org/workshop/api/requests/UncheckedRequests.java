package org.workshop.api.requests;

import org.workshop.api.models.User;
import org.workshop.api.requests.uncheckedRequests.*;

public class UncheckedRequests {
    public UserRequest userRequest;

    public ProjectRequest projectRequest;

    public VcsRequest vcsRequest;

    public BuildTypeRequest buildTypeRequest;

    public BuildRequest buildRequest;

    public UncheckedRequests(User user) {
        userRequest = new UserRequest(user);
        projectRequest = new ProjectRequest(user);
        vcsRequest = new VcsRequest(user);
        buildTypeRequest = new BuildTypeRequest(user);
        buildRequest = new BuildRequest(user);
    }
}
