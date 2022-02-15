package com.w2a.testingfranwork.testcases.paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.testAPIframework.APIs.Paypal.OrderAPI;
import com.w2a.testingfranwork.setup.BaseClass;

import io.restassured.response.Response;

public class createOrderTest extends BaseClass{
static String orderId;
	@Test
	public void createOrder()
	{
	String accessToken= OrderAPI.getAccessToken();
	Response response =OrderAPI.createOrder(accessToken);
	
	Assert.assertEquals(response.getStatusCode(),201);
	response.prettyPrint();
	
	}
}
