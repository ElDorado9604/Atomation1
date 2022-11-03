package testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.LoginPopup;
import pages.HomePage;
import pages.MockTestSeriesPackPage;
import pages.SSC_CGL_TestSeriesPage;
import pages.SSC_CGL_coursePage;
import utils.Utility;

public class VerifyUserAbleToBuySSC_CGL_MockTestSeriesPack {

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
		sSC_CGL_coursePage.clickOnsscCGL_TestSeries();
		
		SSC_CGL_TestSeriesPage sSC_CGL_TestSeriesPage = new SSC_CGL_TestSeriesPage(driver);
		sSC_CGL_TestSeriesPage.clickOnMockTestPack1();
		
		MockTestSeriesPackPage mockTestSeriesPackPage = new MockTestSeriesPackPage(driver);
		mockTestSeriesPackPage.clickOnBuyNow();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.adda247.com/product-testseries/2976/ssc-test-pack-cgl-cpo-chsl-mts-gd-constable-etc#checkout/viewOffers") 
				&& title.equals("Ssc prime test pack with 1000+ complete bilingual tests for ssc cgl,chsl, cpo, gd constable & mts 2022-2023 - Adda247"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		

	}
}
