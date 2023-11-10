package api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.workshop.api.models.Agent;
import org.workshop.api.models.Agents;
import org.workshop.api.requests.CheckedRequests;
import org.workshop.api.requests.UncheckedRequests;
import org.workshop.api.requests.checkedRequests.AgentsRequest;

public class BaseApiTest extends BaseTest {
    public UncheckedRequests unchecked;
    public CheckedRequests checked;

    @BeforeTest
    public void setup() {
        unchecked = new UncheckedRequests(testData.getUser());
        checked = new CheckedRequests(testData.getUser());
    }

    @BeforeTest
    public void authorizeAgent() {
        new AgentsRequest().authorizeAgent();
    }
}
