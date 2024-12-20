package com.TestCRM.TestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.TestCRM.TestBase.TestBase;

public class ReadExcel extends TestBase{
	
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet= null;
	public FileInputStream fi= null;
	public String path;
	public XSSFCell cell;
	public XSSFRow row;
	
	
	
	
	public ReadExcel(String path)
	{
		this.path=path;
	}
	
	
	public int getLastRow(String SheetName)
	{
		try {
			fi = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet= workbook.getSheet(SheetName);
		
		int row= sheet.getLastRowNum();
		
		return row;
	}
	
	
	public int cellNumber(int row, String SheetName) {
		
		try {
			fi= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet= workbook.getSheet(SheetName);
		 
		int cell= sheet.getRow(row).getLastCellNum();
		
		return cell;
		
	}
	
	
	
	public String getCellData(int rownum, int cellnum, String SheetName)
	{
		try {
			fi = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet= workbook.getSheet(SheetName);
		row =sheet.getRow(rownum);
		cell=sheet.getRow(rownum).getCell(cellnum);
		 
		
		DataFormatter formatter = new DataFormatter();
		
		String data=formatter.formatCellValue(cell);
		
		
		return data;
		
		
	}
	

}
