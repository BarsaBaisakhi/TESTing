package basepackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


import utils.ExtentReport;

public class BaseTest extends ExtentReport{
	
	public WebDriver driver;
	protected Logger logger; 

	@BeforeSuite
	public void beforesuite()
	{
		setUpExtentReort();
		
	}
	@BeforeTest
	public void invokeDriver()
	{
		System.setProperty("log4j.configurationFile",  System.getProperty("user.dir")+"\\src\\main\\resources\\configFiles\\log4j2.xml");
		logger= LogManager.getLogger("myLogger");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver =new ChromeDriver();
	    driver.get("https://www.amazon.in/"); 
	    driver.manage().window().maximize();
	    logger.info("Driver invoked in before test method");
	}
	 @AfterMethod
	    public void getResults(ITestResult result) {
		getResult(result,driver);
		 extent.flush();
	 }
	@AfterTest
	public void closeDriver()
	{
		driver.close();
		  logger.info("Driver closed");
	}
	@AfterSuite
	public void afterSuite()
	{
		//report.tearDown();
	}
}
