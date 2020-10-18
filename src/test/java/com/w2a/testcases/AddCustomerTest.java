package com.w2a.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.sql.PseudoColumnUsage;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase{

	

	@Test(dataProvider="getData")
	public void addCustomer(String firstname,String lastname,String postcode,String alerttext) throws InterruptedException
	{
		driver.findElement(By.cssSelector(or.getProperty("addCustBtn"))).click();

		driver.findElement(By.cssSelector(or.getProperty("firstname"))).sendKeys(firstname);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(or.getProperty("lastname"))).sendKeys(lastname);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(or.getProperty("postcode"))).sendKeys(postcode);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(or.getProperty("addCust"))).click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		//Assert.assertTrue(alert.getText().contains(alerttext));
		//alert.accept();
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData()  throws IOException
	{
		String sheetName="AddCustomerTest";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		Object[][] data=new Object[rows-1][cols];
		for (int rowNum = 2; rowNum <=rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
		
	}

}
