package com.w2a.testingfranwork.testcases.stripe;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.w2a.ApiTestingFrameowork.reports.ExtentListeners;
import com.w2a.testingfranwork.setup.BaseClass;
import com.w2a.utility.DataUtil;
import com.w2a.utility.testUtil;

public class DeleteCutsomerTest extends BaseClass{	
	@Test(dataProviderClass =DataUtil.class,dataProvider="data")
	public void deleteCustomer(Hashtable<String,String>data)
	{
		RestAssured.baseURI="https://api.stripe.com/";
		RestAssured.basePath="v1";
		Response response =com.api.testing.stripe.DeleteCustomerTestAPI.senddeleteRequesttoDeleteCustomer(data);
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		ExtentListeners.testReport.get().info(data.toString()); 
		/*String actualID=response.jsonPath().get("id").toString();
		System.out.println("ID of the column is "+actualID);
		Assert.assertEquals(actualID, data.get("id"));*/
		//Assert.assertEquals(response.statusCode(), 200);
		/*JSONObject jsonobject = new JSONObject(response.asString());
		System.out.println(jsonobject.has("id"));
		Assert.assertTrue("ID key is not present", jsonobject.has("id"));*/
		System.out.println("Presence check of the delete key "+testUtil.jsonHasKey(response.asString(),"deleted"));
		System.out.println("Presence check of the object key "+testUtil.jsonHasKey(response.asString(),"object"));
		Assert.assertTrue(testUtil.jsonHasKey(response.asString(), "id"));
		
		String actualid = testUtil.getJsonvalue(response.asString(), "id");
		System.out.println(actualid);
		
		Assert.assertEquals(actualid,data.get("id"), "id not matching");
		System.out.println("Object key value is "+testUtil.getJsonvalue(response.asString(), "object"));
		
		System.out.println("Deleted key value is " +testUtil.getJsonvalue(response.asString(), "deleted"));
	}

	
}
