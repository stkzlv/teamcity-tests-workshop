package org.workshop.api.generators;

import lombok.Builder;
import lombok.Data;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.VCSRoot;
import org.workshop.api.requests.Request;

@Data
@Builder
public class TestData {
    private NewProjectDescription newProjectDescription;
    private VCSRoot vcsRoot;
    private BuildType buildType;

    public void delete() {
        var request = new Request();
        request.deleteProject(newProjectDescription.getId());
        request.deleteVCS(vcsRoot.getId());
        request.deleteBuildConfiguration(buildType.getId());
    }
}
