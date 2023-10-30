package org.workshop.api.generators;

import lombok.Builder;
import lombok.Data;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.User;
import org.workshop.api.models.VCSRoot;
import org.workshop.api.requests.UncheckedRequests;

@Data
@Builder
public class TestData {
    private User user;
    private NewProjectDescription newProjectDescription;
    private VCSRoot vcsRoot;
    private BuildType buildType;

    public void delete() {
        var requests = new UncheckedRequests(user);
        requests.projectRequest.delete(newProjectDescription.getId());
        requests.vcsRequest.delete(vcsRoot.getId());
        requests.buildTypeRequest.delete(buildType.getId());
        requests.userRequest.delete(user.getUsername());
    }
}
