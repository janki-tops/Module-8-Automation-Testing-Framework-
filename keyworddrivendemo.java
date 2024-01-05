package com.framework;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class keyworddrivendemo {
	@DataProvider(name="janki")
	 public Object[][] readExcel() throws Exception, IOException 
	{ 
		Object[][] data=null;
	String filePath="C:\\AUTOMATION TOOLS\\data.xlsx";
	File file=new File(filePath);
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	Sheet sheet=workbook.getSheet("Sheet2");
	int rows=sheet.getPhysicalNumberOfRows();
	System.out.println("Total Rows are :"+ rows);
	data =new Object[rows][];
	for (int i=0;i<data.length;i++)
	{
		Row row=sheet.getRow(i);
		int cols=row.getPhysicalNumberOfCells();
		System.out.println("Total cols are :"+ cols);
		data[i]=new String[cols];
		for (int j=0;j<data[i].length;j++)
		{
			Cell cell=row.getCell(j); 
			cell.setCellType(CellType.STRING);
			data[i][j]=cell.getStringCellValue();
		}
	}
	return data;
	}
	WebDriver driver=null;
	@Test(dataProvider="janki") 
	public void test1(String keyword) throws Exception, Exception, NullPointerException {
		 System.setProperty("webdriver.chrome.driver", "C:\\AUTOMATION TOOLS\\chromedriver.exe");
		 if (keyword.equals("open browser"))
		 {
			 driver=new ChromeDriver();
			  driver.manage().window().maximize();
			 Thread.sleep(2000);
		 }
		 else if(keyword.equals("enter url"))
		 {
			 driver.get("https://www.saucedemo.com/"); 
			 Thread.sleep(2000);
		 }
		 else if (keyword.equals("enter username"))
		 {
			 driver.findElement(By.id("user-name")).sendKeys("standard_user"); 
			 Thread.sleep(2000);
		 } 
		 else if (keyword.equals("enter password"))
		 {
			 driver.findElement(By.id("password")).sendKeys("secret_sauce"); 
			 Thread.sleep(2000);
		 } 
		 else if (keyword.equals("click login"))
		 { driver.findElement(By.id("login-button")).click();
		 Thread.sleep(2000);
		 }
		 else if (keyword.equals("close browser"))
		 {		
			  driver.close();
		 }
	}
}