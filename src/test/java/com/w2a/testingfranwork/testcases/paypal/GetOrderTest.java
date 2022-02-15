package com.w2a.testingfranwork.testcases.paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.testAPIframework.APIs.Paypal.OrderAPI;
import com.w2a.testingfranwork.setup.BaseClass;

import io.restassured.response.Response;

public class GetOrderTest extends BaseClass{


			@Test
		public void getOrder() {
			
			String accessToken = OrderAPI.getAccessToken();
			Response response = OrderAPI.getOrder(accessToken);
			response.prettyPrint();
			
			Assert.assertEquals(response.getStatusCode(),200);
		
	}
}
