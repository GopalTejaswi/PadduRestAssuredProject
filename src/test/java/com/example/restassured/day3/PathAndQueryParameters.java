package com.example.restassured.day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {
	
	
	@Test
	void testQueryAndPathParameters() {		
		
		
		given()
		  //.pathParam("mypath1", "api")
		  .pathParam("mypath", "users")
		  .queryParam("page", 1)
		  .queryParam("id", 8)
		
		
		.when()
		  .get("https://reqres.in/api/{mypath}")
		
		.then()
		  .statusCode(200)
		  .log().all();
		
		
	}

}
