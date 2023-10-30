package org.workshop.api.requests;

import org.checkerframework.checker.units.qual.A;
import org.workshop.api.models.User;
import org.workshop.api.requests.checkedRequests.*;

public class CheckedRequests {

    public UserRequest userRequest;
    public ProjectRequest projectRequest;

    public VcsRequest vcsRequest;

    public BuildTypeRequest buildTypeRequest;

    public BuildRequest buildRequest;

    public AuthRequest authRequest;

    public CheckedRequests(User user) {
        userRequest = new UserRequest(user);
        projectRequest = new ProjectRequest(user);
        vcsRequest = new VcsRequest(user);
        buildTypeRequest = new BuildTypeRequest(user);
        buildRequest = new BuildRequest(user);
        authRequest = new AuthRequest(user);
    }
}
