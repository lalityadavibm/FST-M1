package project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiProject {
	
	private static RequestSpecification reqSpec;
	private String sshKey;
	private int sshKeyId;
	
	@BeforeClass
	public void setUp() {
		reqSpec=new RequestSpecBuilder()
				.setContentType("application/json")
				.addHeader("Authorization", "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")
				.setBaseUri("https://api.github.com")
				.build();
		
	}
	
	@Test
	public void addSSHKey() {
		
		String requestBody = """
            {
            		"title": "TestKey",
            		"key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFOYrsPn+lmzoYAhD21ZxuXVnHxhL6GLn0iQSvcXtybx"
            	}
            }
    """;
		Response response=RestAssured.given().spec(reqSpec).body(requestBody).when().post("/user/keys");
		assertEquals(response.statusCode(),201, "SSH Key was not succesfully created.");
		
		//Extract
		sshKeyId= response.jsonPath().getInt("id");
		assertTrue(sshKeyId > 0, "SSH Key ID is invalid or missing.");
		
		System.out.println("SSH Key ID: " + sshKeyId);
		
	
	}
	
	@Test
	public void getSSHKeys() {
		
		Response response =RestAssured.given()
                .spec(reqSpec)
                .when()
                .get("/user/keys/" + sshKeyId); 

          assertEquals(response.statusCode(), 200, "Failed to fetch the SSH key.");

               Reporter.log("GET Response: " + response.prettyPrint(), true);
		
	}
	
	@Test
	public void deleteSSHKeys() {
		 Response response =RestAssured.given()
                 .spec(reqSpec)
                 .when()
                 .delete("/user/keys/" + sshKeyId);  // Path parameter: keyId


            assertEquals(response.statusCode(), 204, "Failed to delete the SSH key.");

            Reporter.log("DELETE Response: " + response.prettyPrint(), true);
	}

}
