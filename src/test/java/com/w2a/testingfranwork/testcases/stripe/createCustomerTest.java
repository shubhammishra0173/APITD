package com.w2a.testingfranwork.testcases.stripe;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.testing.stripe.CreateCustomerAPI;
import com.w2a.ApiTestingFrameowork.reports.ExtentListeners;
import com.w2a.testingfranwork.setup.BaseClass;
import com.w2a.utility.DataUtil;

public class createCustomerTest extends BaseClass{	
	@Test(dataProviderClass =DataUtil.class,dataProvider="data")
	public void validateCreatecustomerAPIwithvalidSecretKey(Hashtable<String,String>data)
	{
		RestAssured.baseURI="https://api.stripe.com/";
		RestAssured.basePath="v1";
		Response response =CreateCustomerAPI.sendPostreuesttoCreateCreateCustomerwithValidauth(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}
	/*@Test(dataProviderClass =DataUtil.class,dataProvider="data")
	public void validateCreatecustomerAPIwithInvalidSecretKey(Hashtable<String,String>data)
	{
	
		
		Response response = CreateCustomerAPI.sendPostreuesttoCreateCreateCustomerwithinValidauth(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}*/
	
}
