package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPopup {

	//Variable Declaration
	@FindBy (xpath = "//input[@placeholder='Enter full name']")
	private WebElement fullName;
	
	@FindBy (xpath = "//input[@placeholder='Enter email address']")
	private WebElement emailID;
	
	@FindBy (xpath = "//input[@placeholder='Enter password']")
	private WebElement password;
	
	@FindBy (xpath = "//span[text()='SIGNUP']")
	private WebElement signupButton;
	
	@FindBy (xpath = "")
	private WebElement loginOption;
	
	//Variable Initialization
	public SignupPopup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Variable USe
	public void enterFullName()
	{
		fullName.sendKeys("A B");
	}
	public void enterEmailID()
	{
		emailID.sendKeys("asef23@yahoo.com");
	}
	public void enterPassword()
	{
		password.sendKeys("afoai5@");
	}
	public void clickOnSignupbutton()
	{
		signupButton.click();
	}
	public void clickOnLoginOption()
	{
		loginOption.click();
	}
	
}
