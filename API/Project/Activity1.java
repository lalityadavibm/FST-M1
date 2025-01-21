package activities;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Activity1 {
	
	String BASE_URI="https://petstore.swagger.io/v2/pet";
	
	
  @Test
  (priority = 0)
  public void addNewData() {
	  
	  String reqBody="""
		  {
			  "id": 77232,
			  "name": "Riley",
			  "status": "alive"
			}
	  
	 """;
	  
	  Response response=RestAssured.given().contentType(ContentType.JSON)
			  .body(reqBody)
			  .when()
			  .post(BASE_URI);
	  
	  
	//Assertion
			response.then().statusCode(200);
			response.then().body("id", equalTo(77232));
			response.then().body("name", equalTo("Riley"));
			response.then().body("status", equalTo("alive"));
	  
	  
  }
  
  @Test
  (priority = 1)
  public void getData() {
	  
	  String baseURI="https://petstore.swagger.io/v2/pet/{petId}";
	  
	  Response response=RestAssured.given().contentType(ContentType.JSON)
			  .when()
			  .pathParam("petId", 77232)
			  .get(baseURI);
	  
		response.prettyPrint();
		
		//Assertion
		
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));

			  
	  
	
}
  @Test
  (priority = 2)
  public void deleteData() {
	  
	  String BaseUri="https://petstore.swagger.io/v2/pet/{petId}";
	  
	  Response response=RestAssured.given().contentType(ContentType.JSON)
			  .when()
			  .pathParam("petId", 77232)
			  .delete(BaseUri);
	  
		response.prettyPrint();
	  
		response.then().statusCode(200);
		response.then().body("message", equalTo("77232"));

		
}




}
