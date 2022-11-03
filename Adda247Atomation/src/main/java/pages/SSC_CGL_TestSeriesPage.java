package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_CGL_TestSeriesPage {
	//Variable Declaration
	@FindBy (xpath = "//div[@class='col m9 fccontwidth']//img[1]")
	private WebElement mockTestPack1 ; 
	
	//Initialization
	public SSC_CGL_TestSeriesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Variable use
	public void clickOnMockTestPack1()
	{
		mockTestPack1.click();
	}
	
	
	
}
