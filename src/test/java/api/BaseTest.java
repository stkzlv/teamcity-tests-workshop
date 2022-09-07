package api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.workshop.api.generators.TestData;
import org.workshop.api.generators.TestDataGenerator;
import org.workshop.api.requests.CheckedRequest;

public class BaseTest {
    public final TestDataGenerator testDataGenerator = new TestDataGenerator();
    public final CheckedRequest checkedRequest = new CheckedRequest();
    public TestData testData;
    public SoftAssertions softy;

    @BeforeSuite
    public void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "http://admin:admin@localhost:8111";
    }

    @BeforeTest
    public void beforeTest() {
        softy = new SoftAssertions();
        testData = testDataGenerator.generate();
    }

    @AfterTest
    public void afterTest() {
        softy.assertAll();
        testData.delete();
    }
}