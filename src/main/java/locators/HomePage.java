package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class HomePage {

	@FindBy(id="twotabsearchtextbox") 
	public WebElement searchInputField;

	@FindBy(id="nav-search-submit-text")
	public WebElement searchBtn;
	
	@FindBy(id="nav-link-accountList")
	public WebElement signIn;
	
	@FindBy(id="nav-logo-sprites")
	public WebElement amazonLogo;
	
	
	
}
