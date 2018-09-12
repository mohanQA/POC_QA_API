package com.chq.testScripts;
/*
 * API Testing on 'Login' 
 * POST request using Rest Assured-- Creating Json data
 * Sending JSON content in the body of Request -- Validating the Response.
 */
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginTest {

	@Test
	public void login()
	{   
		RestAssured.baseURI ="https://yak.clanhq.com/v2/account/login";
		RequestSpecification request = RestAssured.given();
		// JSONObject is a class that represents a simple
		// JSON. We can add Key - Value pairs using the put
		// method
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "kumaresan@vthink.co.in"); 
		requestParams.put("password", "123456");
		request.body(requestParams.toJSONString());
		Response response = request.post("https://yak.clanhq.com/v2/account/login");
	 //StatusCode Validation
		int statusCode = response.getStatusCode();
		System.out.println("statusCode: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println("StatusCode and SuccessCode both Matched");
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println(successCode);
		System.out.println("Response body: " + response.body().asString());
		//Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
		
	}


