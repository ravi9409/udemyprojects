package com.w2a.testcases;

import java.sql.Driver;import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		System.setProperty("org.uncommons.reportng.escape-output","false");
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector((or.getProperty("bmlBtn")))).click();
		driver.findElement(By.cssSelector(or.getProperty("addCustBtn")));
		log.debug("Test COmpleted");
		Thread.sleep(2000);
		Reporter.log("Login sucessfully executed");
		Reporter.log("<a target=\"blank\" href=\"H:\\selenium practise\\error.jpg\">Screenshot</a>");
		
	}

}
