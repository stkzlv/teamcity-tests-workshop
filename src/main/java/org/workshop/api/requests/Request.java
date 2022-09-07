package org.workshop.api.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.workshop.api.models.Build;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.VCSRoot;
import org.workshop.api.specifications.Specifications;

import static io.restassured.RestAssured.given;

public class Request {
    private static final String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";
    private static final String VCS_ROOTS_ENDPOINT = "/app/rest/vcs-roots";
    private static final String BUILD_TYPES_ENPOINT = "/app/rest/buildTypes";
    private static final String BUILD_QUEUE_ENDPOINT = "/app/rest/buildQueue";
    private static final String BUILDS_ENDPOINT = "/app/rest/builds";
    private final Specifications spec = new Specifications();

    public Response getCsrfToken() {
        return RestAssured.get(AUTHENTICATION_ENDPOINT);
    }

    public Response createProject(NewProjectDescription project) {
        return given().spec(spec.reqSpec()).body(project).post(PROJECT_ENDPOINT);
    }

    public Response createVCS(VCSRoot vcsRoot) {
        return given().spec(spec.reqSpec()).body(vcsRoot).post(VCS_ROOTS_ENDPOINT);
    }

    public Response createBuildConfiguration(BuildType buildType) {
        return given().spec(spec.reqSpec()).body(buildType).post(BUILD_TYPES_ENPOINT);
    }

    public Response runBuildConfiguration(Build build) {
        return given().spec(spec.reqSpec()).body(build).post(BUILD_QUEUE_ENDPOINT);
    }

    public Response getBuild(Long buildId) {
        return given().spec(spec.reqSpec()).get(BUILDS_ENDPOINT + "/id:" + buildId);
    }

    public Response deleteProject(String projectId) {
        return given().spec(spec.reqSpec()).delete(PROJECT_ENDPOINT + "/id:" + projectId);
    }

    public Response deleteVCS(String vcsRootId) {
        return given().spec(spec.reqSpec()).delete(VCS_ROOTS_ENDPOINT + "/id:" + vcsRootId);
    }

    public Response deleteBuildConfiguration(String buildTypeId) {
        return given().spec(spec.reqSpec()).delete(BUILD_TYPES_ENPOINT + "/id:" + buildTypeId);
    }
}
