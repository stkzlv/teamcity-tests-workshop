package org.workshop.api.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.units.qual.C;
import org.workshop.api.Config;
import org.workshop.api.models.User;
import org.workshop.api.requests.CheckedRequests;

import java.util.HashMap;
import java.util.Map;

public class Specifications {
    private static Specifications spec;
    private static final String CSRF_TOKEN = "X-TC-CSRF-Token";

    private Map<String, RequestSpecification> specStorage;

    private Specifications(){
        specStorage = new HashMap<>();
    }

    public static Specifications spec() {
        if (spec == null) { spec = new Specifications(); }
       return spec;
    }

    private RequestSpecification getAuthReqSpec(User user) {
        var requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        var host = Config.getProperty("host");

        requestSpecBuilder.setBaseUri("http://" + user.getUsername() + ":" + user.getPassword()+ "@" + host);

        var csrfToken = new CheckedRequests(user).authRequest.getCsrfToken();
        requestSpecBuilder.addHeader(CSRF_TOKEN, csrfToken);

        return requestSpecBuilder.build();
    }

    private RequestSpecification getUnauthReqSpec() {
        var requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        return requestSpecBuilder.build();
    }

    public RequestSpecification getAdminReqSpec() {
        var requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);

        var superUserToken = Config.getProperty("superUserToken");
        var host = Config.getProperty("host");
        requestSpecBuilder.setBaseUri("http://:" + superUserToken+ "@" + host);
        return requestSpecBuilder.build();
    }

    public RequestSpecification getUserSpec(User user) {
        var reqSpec = getUnauthReqSpec();

        if (user != null) {
            if (specStorage.get(user.getUsername()) != null) {
                reqSpec = specStorage.get(user.getUsername());
            } else {
                reqSpec = getAuthReqSpec(user);
                specStorage.put(user.getUsername(), reqSpec);
            }
        }

        return reqSpec;
    }
}
