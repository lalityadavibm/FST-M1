package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class LoginSteps_Activity6 {

	
	private boolean login(String username, String password) {

		return username.equals("admin1") && password.equals("password1") ||
               username.equals("admin2") && password.equals("password2") ||
               username.equals("admin3") && password.equals("password3");
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.out.println("Navigating to the login page...");
    }

    @When("I enter the following user credentials:")
    public void iEnterTheFollowingUserCredentials(DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
        
        for (Map<String, String> user : users) {
            String username = user.get("username");
            String password = user.get("password");
            System.out.println("Attempting login with username: " + username + " and password: " + password);
            boolean loginResult = login(username, password);
            assertTrue("Login failed for user: " + username, loginResult); // Assert login is successful
        }
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        System.out.println("Login successful!");
    }

}
