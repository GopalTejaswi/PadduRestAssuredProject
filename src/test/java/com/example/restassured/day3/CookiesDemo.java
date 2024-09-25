package com.example.restassured.day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.Map;

public class CookiesDemo {
	
	
	@Test	
	void testCookies() {
		
		given()
		
		
		.when()
		   .get("https://www.google.com/")		
		
		.then()
		  .cookie("AEC", "AVYB7cr9dFiJ15g-YqgmZSOtSO_dBw0bU9oMC5qryCvAjMBv7lwNmH5txM4")
		  .log().all();

		
	}
	
	@Test	
	void getCookiiesInfo() {
		
		Response res=given()
		
		
		.when()
		   .get("https://www.google.com/");
		
		//get single cookie info
		//String cookie_value=res.getCookie("AEC");
		//System.out.println("value of cookie is====>"+cookie_value);
		
		
      //get all cookies info
		Map<String,String>cookies_values=res.getCookies();
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet()) {
			String cookie_value=res.getCookie(k);
			System.out.println(k+"               "+cookie_value);
			
		}
		
	}

}
 