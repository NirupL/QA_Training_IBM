package activities;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity1 {
	String pid;
	
	//POST
	@Test(priority = 1)
	public void postRequestTest() {
		//Request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("name", "Coach");
		reqBody.put("species", "DOG");
		reqBody.put("breed", "Retriever");
		reqBody.put("ageMonths", 20);
		reqBody.put("price", "4000");
		reqBody.put("currency", "USD");
		reqBody.put("status", "AVAILABLE");
		
		//Request specification
		Response response = RestAssured.given().relaxedHTTPSValidation().
		baseUri("https://api.petstoreapi.com/v1/pets").
		//Required headers
		header("Content-Type", "application/json").
		header("Authorization","Bearer abcd-9efg=*").
		header("X-Tenant-ID","550e8400-e29b-41d4-a716-446655449573").
		//Request body
		body(reqBody).
		//Request log functions
		log().all().
	when().post(); //HTTP method specification
	
	pid = response.then().extract().path("id");
	//Assertions
		response.then().statusCode(200);
			
	}

	
	//DELETE https://api.petstoreapi.com/v1/pets/{id}
	@Test(priority = 3)
	public void deleteRequestWithParams() {
		//Request specification
		RestAssured.given().relaxedHTTPSValidation().
		baseUri("https://api.petstoreapi.com/v1/pets").
		//Required headers
		header("Authorization","Bearer abcd-9efg=*").
		header("X-Tenant-ID","550e8400-e29b-41d4-a716-446655449573").
		//Path Parameters
		pathParam("id", pid).
		//Request log functions
		log().all().
	when().delete("/{id}"). //HTTP method specifications
	then().statusCode(204);
			
	}
}
