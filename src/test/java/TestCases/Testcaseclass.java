package TestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



import basepackage.BaseTest;
import locators.HomePage;
import locators.SignInPage;



public class Testcaseclass extends BaseTest{
	
	
	@Test (priority=1)
	public void search() throws InterruptedException {
		HomePage homePage = PageFactory.initElements( driver, HomePage.class);
		test=extent.createTest("search");
		test.info("In search test");
		logger.info("First test started");
		Thread.sleep(3000);
		homePage.searchInputField.sendKeys("books");
		homePage.searchBtn.click();
		test.pass("search successful");
		
	}
	@Test (priority=2)
	public void validateSignInLink()
	{
		HomePage homePage = PageFactory.initElements( driver, HomePage.class);
		test=extent.createTest("validateSignInLink");
		homePage.signIn.isDisplayed();
		assertTrue(false);
		logger.info("Signin link displayed");
	
		
	}
	@Test(priority=3)
	public void validateAmazonLogo()
	{HomePage homePage = PageFactory.initElements( driver, HomePage.class);
		test=extent.createTest("validateAmazonLogo");
		homePage.amazonLogo.isDisplayed();
		logger.debug("logo displayed");
		
	}
	@Test (priority=4)
	public void logIn()
	{HomePage homePage = PageFactory.initElements( driver, HomePage.class);
	SignInPage signinpage=PageFactory.initElements( driver, SignInPage.class);
		test=extent.createTest("logIn");
		homePage.signIn.click();
		signinpage.continueBtn.isDisplayed();
		signinpage.enterEmailAddress.sendKeys("");
		
	}
	@Test
	public void TC5()
	{
		test=extent.createTest("TC5");
	
	}
	@Test
	public void TC6()
	{
		test=extent.createTest("TC6");
		
	}
	@Test
	public void TC7()
	{
		test=extent.createTest("TC7");
		
	}
}
