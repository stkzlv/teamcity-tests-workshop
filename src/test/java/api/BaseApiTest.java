package api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.workshop.api.Config;
import org.workshop.api.requests.CheckedRequests;
import org.workshop.api.requests.UncheckedRequests;

public class BaseApiTest extends BaseTest {
    public UncheckedRequests unchecked;
    public CheckedRequests checked;

    @BeforeTest
    public void setup() {
        unchecked = new UncheckedRequests(testData.getUser());
        checked = new CheckedRequests(testData.getUser());
    }
}
