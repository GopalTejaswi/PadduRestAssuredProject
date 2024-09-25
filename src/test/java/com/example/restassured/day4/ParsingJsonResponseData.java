package com.example.restassured.day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ParsingJsonResponseData {
	
	@Test
	void testJsonResponse() {
		
		given()
		  .contentType("ContentType.JSON")
		
		.when()
		    .get("https://www.google.com/")
		
		.then()
		  .statusCode(200)
		  .header("Content-Type", "text/html; charset=ISO-8859-1")
		  .log().all();
		
	}

}
