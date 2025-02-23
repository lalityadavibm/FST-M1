package project;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.Test;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@ExtendWith(PactConsumerTestExt.class)
public class PactConsumerTest {

    // Create Map for the headers
    Map<String, String> headers = new HashMap<>();
    String createUser = "/api/users"; // Resource URI

    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        // Add headers
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        // Request JSON
        DslPart bodySentCreateUser = new PactDslJsonBody()
            .numberType("id", 1)
            .stringType("firstName", "string")
            .stringType("lastName", "string")
            .stringType("email", "string");

        // Response JSON
        DslPart bodyReceivedCreateUser = new PactDslJsonBody()
            .numberType("id", 1)
            .stringType("firstName", "string")
            .stringType("lastName", "string")
            .stringType("email", "string");

        // Pact contract
        return builder.given("A request to create a user")
            .uponReceiving("A request to create a user")
            .path(createUser)
            .method("POST")
            .headers(headers)
            .body(bodySentCreateUser)
            .willRespondWith()
            .status(201)
            .body(bodyReceivedCreateUser)
            .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8080")
    public void runTest() {
        // Mock URL for the provider
        RestAssured.baseURI = "http://localhost:8080";
        
        // Create request specification
        RequestSpecification rq = given().headers(headers).when();

        // Create request body
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("firstName", "Justin");
        map.put("lastName", "Case");
        map.put("email", "justincase@mail.com");

        // Send POST request
        Response response = rq.body(map).post(createUser);

        // Assertion
        assert(response.getStatusCode() == 201);
    }
}
