package com.example.restassured.day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData() {
		
		Faker faker = new Faker();
		
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		String username = faker.name().username();
		String password = faker.internet().password();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String Email = faker.internet().safeEmailAddress();
	}

}
