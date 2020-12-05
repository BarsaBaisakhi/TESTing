package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
	@FindBy(id="ap_email") 
	public WebElement enterEmailAddress;

	@FindBy(id="continue") 
	public WebElement continueBtn;

	@FindBy(id="ap_password") 
	public WebElement enterPassword;

	@FindBy(id="signInSubmit") 
	public WebElement submitBtn;

}
