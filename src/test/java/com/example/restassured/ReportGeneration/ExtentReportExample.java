package com.example.restassured.ReportGeneration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportExample {
	
	public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void main(String[] args) {
    	
        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html"); deprecated after version 4.0.0
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);

        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        
        test = extent.createTest("Google Search Test", "This is a test to search on Google and validate results");

        try {
            
            driver.get("https://www.google.com");
            test.pass("Navigated to Google homepage");

            
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            test.pass("Entered text into search box");

            
            WebElement searchButton = driver.findElement(By.name("btnK"));
            searchButton.click();
            test.pass("Clicked on the search button");

            
            if (driver.getTitle().contains("Selenium WebDriver")) {
                test.pass("Search results page displayed correctly");
            } else {
                test.fail("Search results page not displayed as expected");
            }

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        } finally {
            
            driver.quit();
            extent.flush();  
        }
    }
}


