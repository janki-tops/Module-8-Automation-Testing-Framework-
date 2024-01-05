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
import org.testng.annotations.Test;

public class datadrivendemo {


@Test public String[][] readExcel() throws Exception, IOException 
{ String[][] data=null;
String filePath="C:\\AUTOMATION TOOLS\\data.xlsx";
File file=new File(filePath);
XSSFWorkbook workbook=new XSSFWorkbook(file);
Sheet sheet=workbook.getSheet("Sheet1");
int rows=sheet.getPhysicalNumberOfRows();
System.out.println("Total Rows are :"+ rows);
data =new String[rows][];
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
@Test 
public void test1() throws Exception, Exception, NullPointerException {
	 System.setProperty("webdriver.chrome.driver", "C:\\AUTOMATION TOOLS\\chromedriver.exe");
	 String[][] data=readExcel();
	  
	  for(int i=0;i<data.length;i++)
	  { 
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com/"); 
		  Thread.sleep(2000);
		  driver.findElement(By.name("user-name")).sendKeys(data[i][0]); 
		  Thread.sleep(2000);
		  driver.findElement(By.name("password")).sendKeys(data[i][1]);
		  Thread.sleep(2000);
		  driver.findElement(By.id("login-button")).click(); Thread.sleep(2000);
		  if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		  { System.out.println("Passes"); 
		  } else 
		  { 
			  System.out.println("Failed");
			  }
		  Thread.sleep(2000); driver.close();
	  }
}

}