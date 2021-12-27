package com.w2a.testingfranwork.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utility.ExcelReader;

import io.restassured.RestAssured;

public class BaseClass {
	private FileInputStream fis;
	public static Properties config = new Properties();
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\excel\\testData.xlsx");

@BeforeSuite
public void setup() throws IOException
{
	fis = new FileInputStream("E:\\REST_API_Testing\\TD_practice_REST\\API-AUTOMATION\\src\\test\\properties\\config.properties");
	
	config.load(fis);
	
	RestAssured.baseURI=config.getProperty("baseURI");
	RestAssured.basePath=config.getProperty("basePath");
	
	
	}
@AfterSuite
public void teardown()
{
	
}



}
