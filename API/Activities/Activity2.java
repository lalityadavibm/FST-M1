package activities;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.PrettyPrinter;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Activity2 {
	
	String BaseURI="https://petstore.swagger.io/v2/user";
	
  @Test(priority=1)
  public void createData() throws IOException {
	  
	  FileInputStream inputJSON = new FileInputStream("C:\\Users\\LalitYadav\\eclipse-workspace\\fst-m1-restassured\\src\\main\\resources\\userInfo.json");
	  Response response=RestAssured.given()
			  .baseUri(BaseURI)
			  .header("Content-Type", "application/json")
			  .body(inputJSON)
			  .when().post();
	  
	  inputJSON.close();

	  response.prettyPrint();
	// Assertion
	  
	  response.then().statusCode(200);
		response.then().body("code", equalTo(200));
			response.then().body("message", equalTo("9911"));
			
			
	  
	  
  }
  @Test(priority=2)
  public void getUserInfo() {
	  
	  File ouputJSON=new File("C:\\Users\\LalitYadav\\eclipse-workspace\\fst-m1-restassured\\src\\main\\resources\\serGETResponse.json");
	Response response=RestAssured.given()
			.baseUri(BaseURI)
			.header("Content-Type", "application/json")
			.pathParam("username", "lalit")
			.when().get("/{username}");
	
	String resBody = response.getBody().asPrettyString();
	
	try {
		// Create JSON file
		ouputJSON.createNewFile();
					// Write response body to external file
					FileWriter writer = new FileWriter(ouputJSON.getPath());
					writer.write(resBody);
					writer.close();
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	// Assertion
			response.then().body("id", equalTo(9911));
			response.then().body("username", equalTo("lalit"));
			response.then().body("firstName", equalTo("Justin"));
			response.then().body("lastName", equalTo("Case"));
			response.then().body("email", equalTo("justincase@mail.com"));
			response.then().body("password", equalTo("password123"));
			response.then().body("phone", equalTo("9812763450"));

}

  @Test(priority=3)
	public void deleteUser() throws IOException {
		Response response = RestAssured.given()
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json")
			.pathParam("username", "lalit") 
			.when().delete("/{username}"); 

		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("lalit"));
	}

}
