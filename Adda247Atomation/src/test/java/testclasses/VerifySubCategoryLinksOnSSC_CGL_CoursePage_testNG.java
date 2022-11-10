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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browserSetup.Base;
import module.LoginPopup;
import pages.HomePage;
import pages.SSC_CGL_coursePage;
import utils.Utility;

public class VerifySubCategoryLinksOnSSC_CGL_CoursePage_testNG extends Base{
	//Working Successful
	private WebDriver driver;
	private HomePage homePage;
	private LoginPopup loginPopup;
	private SSC_CGL_coursePage sSC_CGL_coursePage;
	private SoftAssert soft;
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
		sSC_CGL_coursePage = new SSC_CGL_coursePage(driver);
		homePage = new HomePage(driver);
		loginPopup = new LoginPopup(driver);
	}

	
	@BeforeMethod
	public void openSSC_CGL_coursePage() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.get("https://www.adda247.com/");
		soft = new SoftAssert();//We don't need write code for object of SoftAssert in every test method
		//If we declare it in before_method annotation then object of SoftAssert will be created for every test method
		//And if we create object of SoftAssert in before_class annotation then it will be created only once for 
		//all the test method. And it will add all the test method results in one object then we get Assertion error
		
		homePage.clickOnLoginOption();
		
		String data = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		loginPopup.enterEmailID(data);
		data = Utility.getDataFromExcelSheet("Sheet1", 1, 2);
		loginPopup.enterPassword(data);
		loginPopup.clickOnLoginButton();
		Thread.sleep(6000);
		homePage.clickONsscCGL();
		
	}
	//keywords : priority, invocationCount, dependsOnMethods, enabled, timeOut
	//1. If we don't give priority then priority of tests will be zero then tests will be run based on alphabetical order
	//   of the test method names.
	//2. Test method having lowest priority will be executed first
	//3. Priority can be -ve, zero and +ve.
	//4. We can repeat the particular test method using invocationCount keyword for retesting purpose in which we need to run same test method with multiple data sets
	//5. We use invocationCount from 2,3,4,5,...
	//6. If we don't write invocationCount then by default it is 1.
	//7. If we keep invocationCount = 0 then that method won't be consider for execution so in the console
	//	 it won't be included in the skips as well as total tests run in the default suite
	//8. In dependsOnMethods we write the name of test method on which current test method is depended
	//	 only after that test method pass, current test method will be run
	//	 So current test method will be considered for test execution but it will be skipped if that test method fails
	//	 And in default suite shown in console window will give 1 failure and 1 skipped result if only one test method is dependent.
	//9. If testCase3 depends on multiple testCases then we write like dependsOnMethods = {"testCase1","testCase2"}
	//10. What happens in company if code for any functionality changes then we cannot execute old test method
	//	  but we don't remove old test method we just use enabled = false then testNG will not consider it for execution
	//    And we write new test method for that functionality.
	//11. timeOut keyword is used to specify execution time for test method if it crosses that time we will get hreadTimeOutException
	
	
	@Test (priority = -2 , invocationCount = 2 , /*timeOut = 300000,*/ enabled = true)
	public void Verify_SSC_CGL_TestSeriesButton() throws InterruptedException
	{
		testID = 111001;
		System.out.println("Test1");
		sSC_CGL_coursePage.clickOnsscCGL_TestSeries();
		
		String url = driver.getCurrentUrl();
		Thread.sleep(9000);
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "https://www.adda247.com/ssc-cgl/mock-tests-kit");
		Assert.assertEquals(title, "SSC CGL Mock Test | Avail SSC CGL Test series and prepare online.");
		
	}
	@Test (priority = 1 , enabled = true)
	public void Verify_SSC_CGL_VideoCoursesButton() throws InterruptedException
	{
		testID = 111002;
		System.out.println("Test2");
		
		sSC_CGL_coursePage.clickOnsscCGL_VideoCourse();
		Assert.fail();
		String url = driver.getCurrentUrl();
		Thread.sleep(3000);
		String title = driver.getTitle();
		
		soft.assertEquals(url, "https://www.adda247.com/ssc-cgl/videos-kit");
		soft.assertEquals(title, "SSC CGL Video Lectures 2021 : Join & Prepare with SSC CGL Video Course by Adda247.");
		//In case of soft assert it is mandatory to call assertAll method then only result of this test method will be displayed
		//otherwise by default it will show that test method is passed.
		soft.assertAll();
		
	}
	
	@Test (priority = 2, enabled = true)
	public void Verify_SSC_CGL_OnlineLiveClassesButton() throws InterruptedException
	{
		testID = 111003;
		System.out.println("Test3");
		sSC_CGL_coursePage.clickOnsscCGL_LiveCourse();
		
		String url = driver.getCurrentUrl();
		Thread.sleep(2000);
		String title = driver.getTitle();
		
		boolean result = url.equals("https://www.adda247.com/ssc-cgl/live-classes-kit")
							&& title.equals("SSC CGL Online Coaching Classes 2022 | Join & Prepare with SSC CGL Live Classes by Adda247.");
		Assert.assertTrue(result);//Test method pass/fail decides

	}

	@Test (priority = 3, dependsOnMethods = "Verify_SSC_CGL_VideoCoursesButton" , enabled = true)
	public void Verify_SSC_CGL_ebooksButton() throws InterruptedException
	{
		testID = 111004;
		System.out.println("Test4");
		sSC_CGL_coursePage.clickOnsscCGL_Ebooks();
		
		String url = driver.getCurrentUrl();
		Thread.sleep(2000);
		String title = driver.getTitle();
		
		boolean result = url.equals("https://www.adda247.com/ssc-cgl/ebooks-kit")
					&& title.equals("SSC CGL Ebooks 2022.Prepare with best E-books for SSC CGL by Adda247.");
		soft.assertTrue(result);
		soft.assertAll();
	}
	
	@Test (priority = 4,enabled = true)
	public void Verify_SSC_CGL_BooksButton() throws InterruptedException
	{
		testID = 111005;
		System.out.println("Test5");
		sSC_CGL_coursePage.clickOnsscCGL_Books();
		
		String url = driver.getCurrentUrl();
		Thread.sleep(2000);
		String title = driver.getTitle();
		
		soft.assertEquals(url, "https://www.adda247.com/ssc-cgl/books-kit");
		soft.assertEquals(title, "SSC CGL Books : Adda247 has India's No.1 books for SSC CGL Prepare with them.");
		soft.assertAll();
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
		Thread.sleep(2000);
		homePage.clickOnLogoutBtn();
	}
	
	@AfterClass
	public void clearObject()
	{
		homePage = null;
		loginPopup = null;
		sSC_CGL_coursePage = null;
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
