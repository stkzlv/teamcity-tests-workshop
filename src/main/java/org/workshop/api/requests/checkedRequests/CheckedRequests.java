package org.workshop.api.requests.checkedRequests;

import org.workshop.api.requests.uncheckedRequests.VcsRequest;

public class CheckedRequests {
    public ProjectRequest projectRequest = new ProjectRequest();

    public VcsRequest vcsRequest = new VcsRequest();

    public BuildTypeRequest buildTypeRequest = new BuildTypeRequest();

    public BuildRequest buildRequest = new BuildRequest();

    public AuthRequest authRequest = new AuthRequest();
}
