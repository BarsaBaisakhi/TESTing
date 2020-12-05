package utils;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReport {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	Logger logger = LogManager.getLogger("myLogger");
CaptureScreenshot screenshot=new CaptureScreenshot();
	public void setUpExtentReort() {
	     htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testExtentReport.html");
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
	        extent.setSystemInfo("OS", "Window");
	        extent.setSystemInfo("Browser", "Chrome");
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	public void getResult(ITestResult result,WebDriver driver) {
        if(result.getStatus() == ITestResult.FAILURE) {
        	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
        	test.fail(result.getThrowable());
        	String temp=CaptureScreenshot.getScreenshot(driver);
 			try {
 				test.log(Status.FAIL, result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
 				logger.error("Test case failed and screenshot captured", result.getThrowable());
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
        	
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
        	test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
           
        }
        else {
        	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        	test.skip(result.getThrowable());
        }
    }

	  public void tearDown() {
	    	//to write or update test information to reporter
	        extent.flush();
	    }
}
