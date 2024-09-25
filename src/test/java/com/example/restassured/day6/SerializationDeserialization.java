package com.example.restassured.day6;

import org.testng.annotations.Test;

import com.example.restassured.day2.Pojo_PostRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//POJO ---->Serialize----->JSON Object --->De-serialize------->POJO
public class SerializationDeserialization {
	
	
	@Test
	void convertPojo2Json() throws JsonProcessingException {
		
		
		//created java object using pojo class
		 Student studentpojo = new Student() ;//pojo
			
		 studentpojo.setName("Scott");
		 studentpojo.setLocation("France");
		 studentpojo.setPhone("123456");			
		 String coursesArr[] = {"C", "C++"};
		 studentpojo.setCourses(coursesArr);
		 
		 //convert java object ----> json object(Serialization)
		 ObjectMapper  objMapper = new ObjectMapper();
		 
		 String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentpojo);
		 
		 System.out.println(jsondata);
		 
	}
	@Test
	void convertJson2Pojo() throws JsonProcessingException {
		
		String jsondata = "{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		ObjectMapper  objMapper = new ObjectMapper();
		
		Student stupojo = objMapper.readValue(jsondata, Student.class);//convert json to pojo
		
		System.out.println("Name:"+stupojo.getName());
		System.out.println("Location:"+stupojo.getLocation());
		System.out.println("Phone:"+stupojo.getPhone());
		System.out.println("Course 1:"+stupojo.getCourses()[0]);
		System.out.println("Course 2:"+stupojo.getCourses()[1]);
		
			
		 
		 
	}
	

}
