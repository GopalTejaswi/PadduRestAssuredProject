package com.example.restassured.day8;

import org.testng.annotations.Test;

public class HomeLoan {
	
	/*@Test(groups= {"Group A"})  
	public void testcase1()   
	{  
	System.out.println("Test case belonging to Group A");  
	}  
	@Test(groups= {"Group A","Group B"})  
	public void testcase2()   
	{  
	System.out.println("Test case belonging to both Group A and Group B");  
	}  
	@Test(groups= {"Group B"})  
	public void testcase3()   
	{  
	System.out.println("Test case belonging to Group B");  
	}  
	}  */

	@Test(groups= {"Include Group"})  
	public void test_case1()   
	{  
	System.out.println("This is test case 1");  
	}  
	@Test(groups= {"Include Group"})  
	public void test_case2()   
	{  
	System.out.println("This is test case 2");  
	}  
	@Test(groups= {"Exclude Group"})  
	  
	public void test_case3()   
	{  
	System.out.println("This is test case 3");  
	}  
	}  
