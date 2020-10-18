package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExtentManager;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;



public class TestBase {

	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fileInputStream = null;
	public static WebDriver driver;
	public static Logger log=(Logger) org.apache.log4j.Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait=null;
	public static ExtentTest test;
	public ExtentReports rep= ExtentManager.getInstance();

	@BeforeSuite
	public void setup() {
		if (driver == null) {

			try {
				fileInputStream = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fileInputStream);
				log.debug("Config File Loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileInputStream = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				or.load(fileInputStream);
				log.debug("OR File Loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				 driver = new FirefoxDriver();
			} else

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				 driver = new ChromeDriver();
				 log.debug("CHrome Launched");
			}
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 5);
			driver.manage().window().maximize();
		}
	}
	
	public boolean isElementPresent(By by)
	{
		
		try {
			driver.findElement(by );
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}

	@AfterSuite
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
		log.debug("Test Execution COmpleted");
	}

}
