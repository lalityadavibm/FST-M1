package project;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

public class IBM_Pact_Project {
	
	@Provider("UserProvider")
	@PactFolder("target/pacts")
	public class PactProviderTest {

	    @BeforeEach
	    void before(PactVerificationContext context) {
	        context.setTarget(new HttpTestTarget("localhost", 8080)); // Set the actual Provider's target
	    }

	    @TestTemplate
	    @ExtendWith(PactVerificationInvocationContextProvider.class)
	    void pactTestTemplate(PactVerificationContext context) {
	        context.verifyInteraction(); // Verifies the interaction defined in the contract
	    }

	    @State("A request to create a user")
	    public void sampleState() {
	        // Set up the provider’s state to respond to the request
	    }

	}
}
