package com.TestCRM.TestUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadDataFromExcel {
	
public static LinkedHashMap<String,String> getData(String TestCaseName, String path , String  SheetName) {

	ReadExcel utils= new ReadExcel(path);
	
	int row= utils.getLastRow(SheetName);
	int cell=utils.cellNumber(0, SheetName);
	ArrayList<String> list = new ArrayList<String>();
	LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
	
	for(int r=1;r<=row;r++)
	{
		list.add(utils.getCellData(r, 0,SheetName));
		if(list.get(r-1).equalsIgnoreCase(TestCaseName))
		{
			
			for (int c=1;c<cell;c++)
			{
				map.put(utils.getCellData(0,c,SheetName), utils.getCellData(r,c,SheetName));
			}
			break;
		}
		else
		{
			continue;
		}
	}
	
	return map;

}

public static void main(String[] args) {
	
	LinkedHashMap<String, String> map= getData("TC_01 Verify that user is able to add contact","C://Users//Admin//eclipse-workspace//TestCRM//TestCRMProject//TestData//CRMTestData.xlsx","Sheet1");
	
	
	
	System.out.println(map.get("Company Name"));
	for(Map.Entry<String,String> data : map.entrySet())
	{
		System.out.println(data.getKey() +" : "+ data.getValue());
	}
	
}

}
