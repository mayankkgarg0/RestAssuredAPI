package com.API.apiTestWithRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
@Test(enabled=true)
public void getRequest() {
		           //get request URL need to hit= protocol+baseurl+path+parameter+value
		String url = "https://reqres.in/api/users?page=2";
		
		//create an object of response class
		
		//Restassured will send get request to the url and store response in response object
		Response response = RestAssured.get(url);
		
		//We have to put assertion in response code and response data
		Assert.assertEquals(response.getStatusCode(), 200 , "Response code Mismatch");
		
		int total_pages = response.jsonPath().get("total_pages");
		Assert.assertEquals(total_pages, 2 , "Total Pages value Mismatch");
        
}
    @Test(enabled=false)
     public void postApiRequest() {
    	 
    	 String url = "https://reqres.in/api/users";
    	 String contendType = "application/json";
    	 String bodyData = "{\r\n" + 
    	 		"    \"name\": \"morpheus\",\r\n" + 
    	 		"    \"job\": \"leader\"\r\n" + 
    	 		"}";
    	 Response response = RestAssured.
    			 given().
    			 contentType(contendType).
    			 body(bodyData).
    			 when().
    			 post(url).
    			 then().
    			 extract().
    			 response();
    	 String name = response.jsonPath().get("name");
    	 System.out.println(name);
    	 Assert.assertEquals(response.getStatusCode(), 201 , "Response code Mismatch");
    	 Assert.assertEquals(name, "morpheus" , "Name Mismatch");
    	 
    	 
    	 
     }

		
	}

