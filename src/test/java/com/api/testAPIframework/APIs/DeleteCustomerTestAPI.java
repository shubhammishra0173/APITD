package com.api.testAPIframework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.testingfranwork.setup.BaseClass;

import io.restassured.response.Response;

public class DeleteCustomerTestAPI extends BaseClass{

	public static  Response senddeleteRequesttoDeleteCustomer(Hashtable<String,String>data)
	{
		Response response = given().auth().
				basic(config.getProperty("validSecretKey"), "")
				
				.delete(config.getProperty("customerEndPoint")+"/"+data.get("id"));
				response.prettyPrint();
				return response;
	}
	
}