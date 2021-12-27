package com.w2a.utility;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;


import com.w2a.testingfranwork.setup.BaseClass;

public class DataUtil extends BaseClass{
	
	@DataProvider(name="data",parallel=true)
	public Object[][] getData(Method m)
	{
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\excel\\testData.xlsx");
		int rows =excel.getRowCount(constant.DATA_SHEET);
	System.out.println("Total rows are "+rows);	

	String testName =m.getName();
	int testCaserownum=1;
	//find the test case row
	for (testCaserownum=1;testCaserownum<=rows;testCaserownum++)

	{
		String testcasename= excel.getCellData(constant.DATA_SHEET, 0, testCaserownum);
		//System.out.println(testcasename);
		if(testcasename.equalsIgnoreCase(testName))
		{
			
			break;
		}
		
	}
	System.out.println("Test case starts from row num "+testCaserownum);

	int dataStartrowNum = testCaserownum+2;
	int testrows =0;
	while(!excel.getCellData(constant.DATA_SHEET, 0, dataStartrowNum+testrows).equals(""))
		
	{
	testrows++;	
	}
	System.out.println("total data is "+testrows);


	//find the test case row
	int testcols=0;
	int colStartcols =testCaserownum+1;
	while(!excel.getCellData(constant.DATA_SHEET, testcols, colStartcols).equals(""))
		
		
	{
	testcols++;	
	}
	System.out.println("Total columns are "+testcols);

	// printing data
	Object[][] data=new Object [testrows][1];
	int i =0;
	for(int rNum=dataStartrowNum;rNum<(dataStartrowNum+testrows);rNum++)
	{
		Hashtable<String, String>table = new Hashtable<String,String>();
	for(int cNum=0;cNum<testcols;cNum++)
	{
		//System.out.println(excel.getCellData(constant.DATA_SHEET, cNum, rNum));
		//data[rNum-dataStartrowNum][cNum]=excel.getCellData(constant.DATA_SHEET, cNum, rNum);
		String testData = excel.getCellData(constant.DATA_SHEET, cNum, rNum);
		String colName = excel.getCellData(constant.DATA_SHEET, cNum, colStartcols);
		
		table.put(colName, testData);
	}
	data[i][0]= table;
	i++;
	
	}
	return data;

	}}
