package testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.LoginPopup;
import pages.HomePage;
import pages.SSC_CGL_coursePage;
import utils.Utility;

public class Verify_SSC_CGL_ebooksButton {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\New Program files\\Atomation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.adda247.com/");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginOption();
		
		LoginPopup loginPopup = new LoginPopup(driver);
		String data = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		loginPopup.enterEmailID(data);
		data = Utility.getDataFromExcelSheet("Sheet1", 1, 2);
		loginPopup.enterPassword(data);
		loginPopup.clickOnLoginButton();

		homePage.clickONsscCGL();
		
		SSC_CGL_coursePage sSC_CGL_coursePage = new SSC_CGL_coursePage(driver);
		sSC_CGL_coursePage.clickOnsscCGL_Ebooks();
		
		String url = driver.getCurrentUrl();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		
		if(url.equals("https://www.adda247.com/ssc-cgl/ebooks-kit") 
				&& title.equals("SSC CGL Ebooks 2022.Prepare with best E-books for SSC CGL by Adda247."))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
	}
}
