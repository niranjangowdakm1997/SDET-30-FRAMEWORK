package com.crn.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and wtite data into excel sheet
 * @author User
 *
 */
public class ExcelFileUtility {
	/**
	 * This method used to read the data from excel sheet
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 * 
	 */

	public String readDataFromExcel( String SheetName, int rowNO, int celNo) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		 Row ro = sh.getRow(rowNO);
		Cell cel = ro.getCell(celNo);
		String value = cel.getStringCellValue();
		return value;
	}
	
	/**
	 * This method used to write data into excel sheet
	 * @throws Throwable 
	 * 
	 * 
	 * 
	 */
	public void writeDataIntoExcel(String SheetName, int rowNo, int celNo,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		 Row ro = sh.getRow(rowNo);
		Cell cel = ro.createCell(celNo);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		
	}
	
	/**
	 * This method used to get the no of rows count
	 * @throws Throwable 
	 * 
	 *
	 */
	
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int row=sh.getLastRowNum();
		return row;
	}
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheet name
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}
}
