package api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.workshop.api.Config;
import org.workshop.api.generators.TestData;
import org.workshop.api.generators.TestDataGenerator;

import java.lang.reflect.Type;

public class BaseTest {
    public final TestDataGenerator testDataGenerator = new TestDataGenerator();
    public TestData testData;
    public SoftAssertions softy;

    @BeforeTest
    public void beforeTest() {
        softy = new SoftAssertions();
        testData = testDataGenerator.generate();

        RestAssured.baseURI = "http://" + Config.getProperty("host");

        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                new Jackson2ObjectMapperFactory() {
                    @Override
                    public ObjectMapper create(Type type, String s) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        return objectMapper;                    }
                }
        ));
    }

    @AfterTest
    public void afterTest() {
        softy.assertAll();
        testData.delete();
    }
}
