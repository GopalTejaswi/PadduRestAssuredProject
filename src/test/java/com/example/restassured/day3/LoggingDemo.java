package com.example.restassured.day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class LoggingDemo {
	@Test	
	void testlogs() {
		
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		
		.then()
		 //.log().body();
		.log().headers();
		
	}

}
