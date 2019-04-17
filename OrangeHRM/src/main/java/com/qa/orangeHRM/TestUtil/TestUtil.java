package com.qa.orangeHRM.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.orangeHRM.TestBase.TestBase;

public class TestUtil extends TestBase{

	
	public String getScreenShot(String strNameOfSS){
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String userDir= System.getProperty("user.dir");
		Date dt= new Date();
		String dateTime= new SimpleDateFormat("ddMMMYYYYHHmmss").format(dt);
		String destination = userDir+"\\Screenshots\\"+strNameOfSS+ dateTime+ ".png";
		File destFile= new File(destination);
		try {
			FileHandler.copy(src, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
		
	}
	
	public Object[][] readExcelDate(String excelPath){
		FileInputStream fis = null;
		XSSFWorkbook book = null;
	try {
		fis= new FileInputStream(excelPath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		book=  new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	XSSFSheet sh= book.getSheetAt(0);
	int rowCount= sh.getLastRowNum();
	int colCount = sh.getRow(1).getLastCellNum();
	
	Object[][] data= new Object[rowCount][colCount];
	for(int i=0; i< rowCount; i++){
		for (int j=0;j<colCount; j++){
			data[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();
			
		}
	}
	
	
	return data;
	
	
	}
}
