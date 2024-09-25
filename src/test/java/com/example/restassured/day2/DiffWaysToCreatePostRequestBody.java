package com.example.restassured.day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

/*Different ways we can create request body
1) using HashMap
2) using Org.json
3) using POJO (Plain Old Java Object)
4) using external json file*/

public class DiffWaysToCreatePostRequestBody {

	// 1) using HashMap

	@Test(priority = 1)
	void testPostusingHashMap() {

		HashMap data = new HashMap();

		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String coursesArr[] = {"C", "C++"};
		data.put("courses", coursesArr);
		
		given()
		  .contentType("application/json")
		  .body(data)

		.when()
		    .put("http://localhost:3000/students")

		.then()
		   .statusCode(200)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("France"))
		   .body("phone", equalTo("123456"))
		   .body("courses[0]", equalTo("C"))
		   .body("courses[1]", equalTo("C++"))
		   .header("Content-Type", "application/json; charset=utf-8")
		   .log().all();
		

	}

	/*
	 * @Test(priority = 2) void testPostusingJsonLibrary() {
	 * 
	 * JSONObject data = new JSONObject();
	 * 
	 * data.put("name", "Scott"); data.put("location", "France"); data.put("phone",
	 * "123456");
	 * 
	 * String coursesArr[] = {"C", "C++"}; data.put("courses", coursesArr);
	 * 
	 * given() .contentType("application/json") .body(data.toString())
	 * 
	 * .when() .put("http://localhost:3000/students")
	 * 
	 * .then() .statusCode(201) .body("name", equalTo("Scott")) .body("location",
	 * equalTo("France")) .body("phone", equalTo("123456")) .body("courses[0]",
	 * equalTo("C")) .body("courses[1]", equalTo("C++")) .header("Content-Type",
	 * "application/json; charset=utf-8") .log().all();
	 * 
	 * }
	 */
	
	@Test
	 void postRequestUsingPOJOClass() {
			
		 Pojo_PostRequest data = new Pojo_PostRequest() ; 
			
			data.setName("Scott");
			data.setLocation("France");
			data.setPhone("123456");			
			String coursesArr[] = {"C", "C++"};
			data.setCourses(coursesArr);
			
			given()
			  .contentType("application/json")
			  .body(data)

			.when()
			    .put("http://localhost:3000/students")

			.then()
			   .statusCode(201)
			   .body("name", equalTo("Scott"))
			   .body("location", equalTo("France"))
			   .body("phone", equalTo("123456"))
			   .body("courses[0]", equalTo("C"))
			   .body("courses[1]", equalTo("C++"))
			   .header("Content-Type", "application/json; charset=utf-8")
			   .log().all();
			
		}

		
			
		}
	


