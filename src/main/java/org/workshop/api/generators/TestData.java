package org.workshop.api.generators;

import lombok.Builder;
import lombok.Data;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.VCSRoot;
import org.workshop.api.requests.uncheckedRequests.UncheckedRequests;

@Data
@Builder
public class TestData {
    private NewProjectDescription newProjectDescription;
    private VCSRoot vcsRoot;
    private BuildType buildType;

    public void delete() {
        var requests = new UncheckedRequests();
        requests.projectRequest.delete(newProjectDescription.getId());
        requests.vcsRequest.delete(vcsRoot.getId());
        requests.buildTypeRequest.delete(buildType.getId());
    }
}
