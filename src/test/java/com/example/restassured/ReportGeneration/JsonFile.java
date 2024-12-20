package com.example.restassured.ReportGeneration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonFile {
	
	    public static void main(String[] args) {
	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        try {
	            
	            File jsonFile = new File("C:\\\\Users\\\\Teja\\\\Desktop\\\\Padmini\\\\test.json");
	            
	            
	            Map<String, Object> data = objectMapper.readValue(jsonFile, new TypeReference<Map<String, Object>>() {});
	            
	            
	            System.out.println("Working Directory = " + System.getProperty("user.dir"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


