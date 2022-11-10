package testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browserSetup.Base;
import module.LoginPopup;
import pages.HomePage;
import pages.MockTestSeriesPackPage;
import pages.SSC_CGL_TestSeriesPage;
import pages.SSC_CGL_coursePage;
import utils.Utility;

public class VerifySSC_CGL_TestSeriesFunctionality_testNG extends Base{
	//Working Successful
	private WebDriver driver;
	private HomePage homePage;
	private LoginPopup loginPopup;
	private SSC_CGL_TestSeriesPage sSC_CGL_TestSeriesPage ;
	private SSC_CGL_coursePage sSC_CGL_coursePage;
	private MockTestSeriesPackPage mockTestSeriesPackPage;
	private int testID;
	
	//ExtendReport
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	//ExtendReport
	
	@Parameters ("browser")
	@BeforeTest
	public void browserLaunch(String browserName)
	{
		//ExtendReport
		reporter = new ExtentHtmlReporter("test-output/ExtentReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		//ExtendReport
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = openMSEdgeBrowser();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMObjects()
	{
		sSC_CGL_TestSeriesPage = new SSC_CGL_TestSeriesPage(driver);
		sSC_CGL_coursePage = new SSC_CGL_coursePage(driver);
		mockTestSeriesPackPage = new MockTestSeriesPackPage(driver);
		homePage = new HomePage(driver);
		loginPopup = new LoginPopup(driver);
	}
	
	@BeforeMethod
	public void openSSC_CGL_coursePage() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.get("https://www.adda247.com/");

		homePage.clickOnLoginOption();
		
		String data = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		loginPopup.enterEmailID(data);
		data = Utility.getDataFromExcelSheet("Sheet1", 1, 2);
		loginPopup.enterPassword(data);
		loginPopup.clickOnLoginButton();
		Thread.sleep(6000);
		homePage.clickONsscCGL();
		
	}
	
	@Test (priority = 1)
	public void Verify_SSC_CGL_TestSeriesButton() throws InterruptedException
	{
		testID = 222001;
		sSC_CGL_coursePage.clickOnsscCGL_TestSeries();
		
		String url = driver.getCurrentUrl();
		Thread.sleep(15000);
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "https://www.adda247.com/ssc-cgl/mock-tests-kit");
		Assert.assertEquals(title, "SSC CGL Mock Test | Avail SSC CGL Test series and prepare online.");
	}
	
	
	@Test (priority = 2/*dependsOnMethods = "Verify_SSC_CGL_TestSeriesButton"*/)
	public void VerifyUserAbleToBuySSC_CGL_MockTestSeriesPack() throws InterruptedException
	{
		testID = 222002;
		sSC_CGL_coursePage.clickOnsscCGL_TestSeries();
		
		sSC_CGL_TestSeriesPage.clickOnMockTestPack1();
		
		mockTestSeriesPackPage.clickOnBuyNow();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "https://www.adda247.com/product-testseries/2976/ssc-test-pack-cgl-cpo-chsl-mts-gd-constable-etc#checkout/viewOffers");
		Assert.assertEquals(title,"Ssc prime test pack with 1000+ complete bilingual tests for ssc cgl,chsl, cpo, gd constable & mts 2022-2023 - Adda247" );
		
		Thread.sleep(5000);
		
		mockTestSeriesPackPage.closeCheckoutPopup();
		Assert.fail();
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws InterruptedException, IOException
	{
		if(result.FAILURE == result.getStatus())
		{
			Utility.captureScreen(driver, testID);
		}
		Thread.sleep(20000);
		homePage.clickOnAccountTab();
		Thread.sleep(5000);
		homePage.clickOnLogoutBtn();
	}
	
	@AfterClass
	public void clearObject()
	{
		homePage = null;
		loginPopup = null;
		sSC_CGL_TestSeriesPage = null;
		sSC_CGL_coursePage = null;
		mockTestSeriesPackPage = null;
	}

	
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
		driver = null;
		//To remove all objects without references
		System.gc();	//Garbage Collector
	}
	
}
