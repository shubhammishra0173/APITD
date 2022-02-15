package com.api.testing.stripe;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.testingfranwork.setup.BaseClass;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseClass{

	public static  Response sendPostreuesttoCreateCreateCustomerwithValidauth(Hashtable<String,String>data)
	{
		Response response = given().auth().
				basic(data.get("validsecretkey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerEndPoint"));
				response.prettyPrint();
				return response;
	}
	public static  Response sendPostreuesttoCreateCreateCustomerwithinValidauth(Hashtable<String,String>data)
	{
		Response response = given().auth().
				basic(config.getProperty("invalidSecretkey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerEndPoint"));
		return response;
	}
}
