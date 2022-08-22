package org.workshop.api.generators;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomData {
    private static final int STRING_LENGTH = 10;
    private final java.util.Random random = new Random();

    public String getString() {
        return "test_" + RandomStringUtils.randomAlphanumeric(STRING_LENGTH);
    }

    public Boolean getBoolean() {
        return random.nextBoolean();
    }
}
