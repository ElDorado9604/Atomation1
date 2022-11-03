package testclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.LoginPopup;
import pages.HomePage;
import utils.Utility;

public class VerifyLogin {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\New Program files\\Atomation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.adda247.com/");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginOption();
		
		LoginPopup loginPopup = new LoginPopup(driver);
		String data = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		loginPopup.enterEmailID(data);
		data = Utility.getDataFromExcelSheet("Sheet1", 1, 2);
		loginPopup.enterPassword(data);
		loginPopup.clickOnLoginButton();
		
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
