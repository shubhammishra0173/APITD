package com.w2a.testingframeowrk.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	
	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		
		FileInputStream fis = new FileInputStream("E:\\REST_API_Testing\\TD_practice_REST\\API-AUTOMATION\\src\\test\\properties\\config.properties");
		
		config.load(fis);
		System.out.println(config.getProperty("baseURI"));
	}
}
