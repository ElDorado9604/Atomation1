package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopup {
	//Variable Declaration
	@FindBy (xpath = "//input[@placeholder='Enter email address']")
	private WebElement emailID ;
	
	@FindBy (xpath = "//input[@placeholder = 'Enter password']")
	private WebElement password ;
	
	@FindBy (xpath = "//span[@class='button-text']")
	private WebElement loginButton ;
	
	@FindBy (xpath = "//span[text() = ' Signup']")
	private WebElement signupOption ;
	
	@FindBy (xpath = "//span[text()='Forgot Password?']")
	private WebElement forgotPassword ;
	
	//Variable Initialization
	public LoginPopup (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Variable Use
	public void enterEmailID(String email)
	{
		emailID.sendKeys(email);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public void clickOnSignupOption()
	{
		signupOption.click();
	}
	
	

}
