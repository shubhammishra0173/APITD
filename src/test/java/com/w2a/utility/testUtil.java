package com.w2a.utility;

import org.json.JSONObject;

import com.w2a.ApiTestingFrameowork.reports.ExtentListeners;

public class testUtil {
	
	public static boolean jsonHasKey(String json,String key)
	{
		
		JSONObject jsonobject = new JSONObject(json);
		ExtentListeners.testReport.get().info("validating the presence of key "+key);
		
		return jsonobject.has(key);
	}
	public static String getJsonvalue(String json,String key)
	{
		JSONObject jsonobject = new JSONObject(json);
		ExtentListeners.testReport.get().info("validating value of key "+key);
		return jsonobject.get(key).toString();
	}

}
