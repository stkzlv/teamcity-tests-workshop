package org.workshop.api.requests;

import org.apache.http.HttpStatus;
import org.workshop.api.enums.BuildState;
import org.workshop.api.models.*;

public class CheckedRequest {
    private static final long TIMEOUT = 60_000;
    private final Request request = new Request();

    public String getCsrfToken() {
        return request.getCsrfToken()
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }

    public Project createProject(NewProjectDescription project) {
        return request.createProject(project)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Project.class);
    }

    public VCSRoot createVCS(VCSRoot vcsRoot) {
        return request.createVCS(vcsRoot)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(VCSRoot.class);
    }

    public BuildType createBuildConfiguration(BuildType buildType) {
        return request.createBuildConfiguration(buildType)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(BuildType.class);
    }

    public Build runBuildConfiguration(Build build) {
        return request.runBuildConfiguration(build)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);
    }

    public Build getBuild(Long buildId) {
        return request.getBuild(buildId)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Build.class);
    }

    public void waitUntilBuildFinished(Long buildId) {
        var startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < TIMEOUT) {
            var build = getBuild(buildId);
            if (build.getState() != null && build.getState().equals(BuildState.FINISHED.getValue())) {
                break;
            }
        }
    }

    public void deleteProject(String projectId) {
        request.deleteProject(projectId)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    public void deleteVCS(String vcsRootId) {
        request.deleteProject(vcsRootId)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    public void deleteBuildConfiguration(String buildTypeId) {
        request.deleteProject(buildTypeId)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
