package api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.workshop.api.Config;
import org.workshop.api.generators.TestData;
import org.workshop.api.generators.TestDataGenerator;

public class BaseTest {
    public final TestDataGenerator testDataGenerator = new TestDataGenerator();
    public TestData testData;
    public SoftAssertions softy;

    @BeforeTest
    public void beforeTest() {
        softy = new SoftAssertions();
        testData = testDataGenerator.generate();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "http://" + Config.getProperty("host");
    }

    @AfterTest
    public void afterTest() {
        softy.assertAll();
        testData.delete();
    }
}
