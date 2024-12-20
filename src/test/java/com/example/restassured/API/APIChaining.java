package com.example.restassured.API;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIChaining {

	@Test
	void getAllEmployees() {

		given()

				.when()
				   .get("https://reqres.in/api/users?page=2")
				.then()
				   .statusCode(200)
				   .log().all();

	}

	@Test
	void findEmployeeByID() {

		int id = given()
				
				.when()
				  .get("https://reqres.in/api/users?page=1")
				.then()
				  .extract()
				  .path("data[1].id", "id");

		given()
		   .pathParam("id", id)
		.when()
			.get("https://reqres.in/api/users/{id}")
		.then()
			.assertThat()
			.body("data.first_name", equalTo("Janet"))
			.log().body();
	}

	@Test(dependsOnMethods = {"findEmployeeByID"} )
	void updateEmployeeByEmail() {
		
		HashMap update = new HashMap();
		update.put("first_name", "Riya");
		update.put("email", "riya@reqres.in" );
		
		given()
		 .contentType("application/json")
		 .body(update)
		
		.when()		 
		 .put("https://reqres.in/api/users/2")
		
		.then()		 
		 .statusCode(200)
		 .log().all();
		

	}
	
	@Test
	void deleteEmployeeById() {
		
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/2")
		
		.then()
		 .statusCode(204)
		 .log().all();
		
	}
	
	
	@Test
	void getObject() {
		
		Response response = given()
		.when()
		  .get("https://reqres.in/api/users?page=1");
		
		JsonPath jsonPath = response.jsonPath();
		Object data2 = jsonPath.get("data[2]");
		Object data2Id = jsonPath.get("data[2].id");
		Object data2fn = jsonPath.get("data[2].first_name");
		Object data2ln = jsonPath.get("data[2].last_name");
		
		
		
		System.out.println("data2:"+ data2);
		System.out.println("data2Id:"+ data2Id);
		System.out.println("data2fn:"+ data2fn);
		System.out.println("data2ln:"+ data2ln);
		
		
	}
}
