package testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.LoginPopup;
import module.SignupPopup;
import pages.HomePage;

public class VerifySignup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\New Program files\\Atomation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.adda247.com/");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginOption();
		
		LoginPopup loginPopup = new LoginPopup(driver);
		loginPopup.clickOnSignupOption();
		
		SignupPopup signupPopup  = new SignupPopup(driver);
		signupPopup.enterFullName();
		signupPopup.enterEmailID();
		signupPopup.enterPassword();
		signupPopup.clickOnSignupbutton();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.adda247.com/") 
				&& title.equals("Adda247 - India’s No.1 Government Job Preparation platform"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		

	}
}
