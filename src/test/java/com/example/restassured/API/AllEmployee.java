package com.example.restassured.API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AllEmployee {
	    
	    public static void setup() {
	        RestAssured.baseURI = "http://localhost:8071";
	    }
	   
	    @Test
	    public void testGetAllEmployeesSuccess() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(200)
	                .contentType("application/json")
	                .body("size()", greaterThan(0));
	    }

	   
	    @Test
	    public void testGetAllEmployeesEmptyList() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(200)
	                .body("size()", equalTo(0));
	    }

	    
	    @Test
	    public void testInvalidEndpoint() {
	        given()
	            .when()
	                .get("/findAllEmployee")
	            .then()
	                .statusCode(404);
	    }

	    
	    @Test
	    public void testUnauthorizedAccess() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(401);
	    }

	    
	    @Test
	    public void testInvalidDataFormat() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(200)  
	                .contentType("application/json") 
	                .body("employeeId", isA(Integer.class)) 
	                .body("employeeName", isA(String.class)); 
	    }

	    
	    @Test
	    public void testPerformanceForLargeDataset() {
	        long startTime = System.currentTimeMillis();

	        Response response = given()
	            .when()
	                .get("/findAllEmployees");

	        long endTime = System.currentTimeMillis();
	        long duration = endTime - startTime;

	        
	        response.then().statusCode(200);
	        assert(duration < 2000); 
	    }

	    
	    @Test
	    public void testInternalServerError() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(500); 
	    }

	   
	    @Test
	    public void testEmployeeDataStructure() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(200) 
	                .body("employeeId", everyItem(isA(Integer.class)))  
	                .body("employeeName", everyItem(isA(String.class))) 
	                .body("employeeDepartment", everyItem(isA(String.class)));
	    }

	    
	    @Test
	    public void testMissingEmployeeFields() {
	        given()
	            .when()
	                .get("/findAllEmployees")
	            .then()
	                .statusCode(200)
	                .body("employeeId", notNullValue())  
	                .body("employeeName", notNullValue()) 
	                .body("employeeDepartment", notNullValue());
	    }
}
	        


