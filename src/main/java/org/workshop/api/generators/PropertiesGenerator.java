package org.workshop.api.generators;

import org.workshop.api.enums.AuthMethod;
import org.workshop.api.models.Properties;
import org.workshop.api.models.Property;

import java.util.Arrays;

public class PropertiesGenerator {
    private final RandomData randomData = new RandomData();

    public Properties getBasicVcsProperties() {
        return Properties.builder()
                .property(Arrays.asList(
                        new Property("authMethod", AuthMethod.ANONYMOUS.getValue()),
                        new Property("branch", "refs/heads/" + randomData.getString()),
                        new Property("url", "https://github.com/AlexPshe/spring-core-for-qa")
                ))
                .build();
    }

    public Properties getBasicStepProperties(String scriptContent) {
        return Properties.builder()
                .property(Arrays.asList(
                        new Property("script.content", scriptContent),
                        new Property("teamcity.step.mode", "default"),
                        new Property("use.custom.script", "true")
                ))
                .build();
    }
}
