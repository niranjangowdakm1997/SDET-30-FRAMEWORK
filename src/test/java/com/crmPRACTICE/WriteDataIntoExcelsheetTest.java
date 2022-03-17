package com.crmPRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelsheetTest {
	
	@Test
	
	public void writeDataintoExcelSheetTest() throws EncryptedDocumentException, IOException
	{
		//step 1: open the file in read mode
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Niranjan.xlsx");
		
		//step 2: create workbook
	    Workbook wb = WorkbookFactory.create(fis);
				
				//step 3: get the sheet
				Sheet sh = wb.getSheet("Sheet1");
				
				//step 4: get the row
				Row ro = sh.createRow(5);
				
				//step 5: get the cell
				Cell ce = ro.createCell(0);
				
				ce.setCellValue("tc_1000");
				
				//open the file in write mode
				FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Niranjan.xlsx");
				wb.write(fos);
	}

}
