package com.api.testAPIframework.APIs.Paypal;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.api.testingfarmework.pojo.Orders;
import com.w2a.api.testingfarmework.pojo.PurchaseUnits;
import com.w2a.testingfranwork.setup.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderAPI extends BaseClass{
	static String access_token;
	static String client_id=config.getProperty("paypalclientId");
	static String secret=config.getProperty("payaplsecretId");
	static String orderId;
	@Test(priority=1)
	public static String getAccessToken() {

		String access_token = given().param("grant_type", "client_credentials")
				.auth().preemptive()
				.basic(client_id, secret)
				.post("/v1/oauth2/token")
				.jsonPath()
				.get("access_token").toString();

		return access_token;

	}

public static Response createOrder(String access_token) {
		
		ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
		list.add(new PurchaseUnits("USD","500.00"));
		Orders order = new Orders("CAPTURE",list);
		
		Response resposne = given()
		.contentType(ContentType.JSON)
		.auth().oauth2(access_token)
		.body(order)
		.post("/v2/checkout/orders");
		
		orderId = resposne.jsonPath().get("id").toString();
		
		
		return resposne;
	}
	
	

	public static Response getOrder(String access_token) {

		System.out.println("Order id is : "+orderId);
		Response resposne = given()
				.contentType(ContentType.JSON)
				.auth().oauth2(access_token)
				
				.get("/v2/checkout/orders"+"/"+orderId);
		
		return resposne;
	}
}
