package activities;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity2 {
	//Request and response specs
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String petId;
	
	//SetUp functions
	@BeforeClass
	public void setUp() {
		//Common Request specifications
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://api.petstoreapi.com/v1/pets").
				addHeader("Content-Type", "application/json").
				addHeader("Authorization","Bearer abcd-9efg=*").
				addHeader("X-Tenant-ID","550e8400-e29b-41d4-a716-446655449573").
				build();
		
		//Common Response specifications
		responseSpec = new ResponseSpecBuilder().
				expectBody("status", Matchers.equalTo("ADOPTED")).
				expectBody("goodWithKids", Matchers.equalTo(true)).
				expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
				build();
	}
	
	@Test(priority = 1)
	public void postRequestTest() {
		//JSON request body file
		File inputJson = new File("src/test/resources/pet.json");
		//Request specification
		Response response = given().relaxedHTTPSValidation().
		spec(requestSpec)
		//Request body
		.body(inputJson).  //Collection(Map) or File
		log().all().
	when().post(); //HTTP method specification
	
		//Extract the id of the pet
		this.petId = response.then().extract().path("id");
		
		//Response Specification
		response.then().log().all()
			.statusCode(201)
			.body("name", Matchers.equalTo("Donut"))
			.body("size", Matchers.equalTo("SMALL"))
			.spec(responseSpec);
			
	}
	
	//GET https://api.petstoreapi.com/v1/pets?status=ADOPTED
		@Test(priority = 2)
		public void getRequestWithQueryParameters() {
			//Request specification
			given().relaxedHTTPSValidation().
			spec(requestSpec)
			//Query Parameters
			.pathParam("id", this.petId).
			//Request log functions
			log().all().
		when().get("/id") //HTTP method specifications
			
		//Response Specification
			.then().log().all()
			.statusCode(200)
			.body("name", Matchers.equalTo("Donut"))
			.body("size", Matchers.equalTo("SMALL"))
			.spec(responseSpec);
				
		}
		
		//DELETE https://api.petstoreapi.com/v1/pets/{id}
		@Test(priority = 3)
		public void deleteRequestWithParams() {
			//Request specification
			given().relaxedHTTPSValidation().
				spec(requestSpec)
				.pathParam("id", this.petId).
			//Request log functions
			log().all().
		when().delete("/{id}"). //HTTP method specifications
		then().log().all()
			.statusCode(204)
			.time(Matchers.lessThanOrEqualTo(3000L));
				
		}
}
