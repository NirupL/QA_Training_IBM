package examples;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	//POST
	@Test(priority = 1)
	public void postRequestTest() {
		//Request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("name", "Max");
		reqBody.put("species", "DOG");
		reqBody.put("breed", "Husky");
		reqBody.put("ageMonths", 20);
		reqBody.put("price", "3456");
		reqBody.put("currency", "USD");
		reqBody.put("status", "ADOPTED");
		
		//Request specification
		RestAssured.given().relaxedHTTPSValidation().
		baseUri("https://api.petstoreapi.com/v1/pets").
		//Required headers
		header("Content-Type", "application/json").
//		header(ContentType.JSON)
		header("Authorization","Bearer abcd-9efg=*").
		header("X-Tenant-ID","550e8400-e29b-41d4-a716-446655449573").
		//Request body
		body(reqBody).
		//Request log functions
		log().all().
	when().post(). //HTTP method specification
	then().
	//Response log functions
	log().all().
	statusCode(201).
	body("status", Matchers.equalTo("ADOPTED"));
			
	}
	
	//GET https://api.petstoreapi.com/v1/pets?status=ADOPTED
	@Test(priority = 2)
	public void getRequestWithQueryParameters() {
		//Request specification
		Response response = RestAssured.given().relaxedHTTPSValidation().
		baseUri("https://api.petstoreapi.com/v1/pets").
		//Required headers
		header("X-Tenant-ID","550e8400-e29b-41d4-a716-446655449573").
		//Query Parameters
		queryParam("status", "ADOPTED").
		//Request log functions
		log().all().
	when().get(); //HTTP method specifications
		
	//Get the response status codes
	System.out.println(response.statusCode());
	//Get the Response body
//	System.out.println(response.getBody().asPrettyString());
	System.out.println(response.getBody().asString());
	//Get the response headers
	System.out.println(response.getHeaders().asList());
	
	//Extract the response from the response JSON
	String petStatus = response.then().extract().path("data[0].status");
	
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
		pathParam("id", "019eda56-48df-76e2-8b65-51d56fdc8261").
		//Request log functions
		log().all().
	when().delete("/{id}"). //HTTP method specifications
	then().statusCode(204);
			
	}
}
