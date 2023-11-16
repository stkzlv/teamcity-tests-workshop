package org.workshop.api.specifications;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.workshop.api.Config;
import org.workshop.api.models.User;

import java.util.HashMap;
import java.util.Map;

public class Specifications {
    private static Specifications spec;
    private static final String CSRF_TOKEN = "X-TC-CSRF-Token";

    private Map<String, RequestSpecification> specStorage;

    private Specifications() {
        specStorage = new HashMap<>();
    }

    public static Specifications spec() {
        if (spec == null) {
            spec = new Specifications();
        }
        return spec;
    }

    private RequestSpecBuilder baseReqBuilder() {
        var baseReqBuilder = new RequestSpecBuilder();
        baseReqBuilder.addFilter(new RequestLoggingFilter());
        baseReqBuilder.addFilter(new ResponseLoggingFilter());
        baseReqBuilder.addFilter(new SwaggerCoverageRestAssured());
        baseReqBuilder.addFilter(new AllureRestAssured());
        return baseReqBuilder;
    }

    private RequestSpecification getAuthReqSpec(User user) {
        var requestSpecBuilder = baseReqBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        var host = Config.getProperty("host");
        requestSpecBuilder.setBaseUri("http://" + user.getUsername() + ":" + user.getPassword() + "@" + host);
        return requestSpecBuilder.build();
    }

    private RequestSpecification getUnauthReqSpec() {
        var requestSpecBuilder = baseReqBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAccept(ContentType.JSON);
        return requestSpecBuilder.build();
    }

    public RequestSpecification getAdminReqSpec(ContentType contentType) {
        var requestSpecBuilder = baseReqBuilder();
        requestSpecBuilder.setContentType(contentType);
        requestSpecBuilder.setAccept(contentType);
        var superUserToken = Config.getProperty("superUserToken");
        var host = Config.getProperty("host");
        requestSpecBuilder.setBaseUri("http://:" + superUserToken + "@" + host);
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
