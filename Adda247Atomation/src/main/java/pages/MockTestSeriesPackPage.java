package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MockTestSeriesPackPage {
	//Variable Declaration
		WebDriver driver;
		WebDriverWait wait;
		JavascriptExecutor js;
		
		@FindBy (xpath = "//button[text()='Buy Now']")
		private WebElement buyNow ;
		
		@FindBy (xpath = "//div[@class='buynow-close-icon']")
		private WebElement buynow_close_icon;
		
		//Initialization
		public MockTestSeriesPackPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			js = (JavascriptExecutor) driver;
		}
		
		//Variable use
		public void clickOnBuyNow() throws InterruptedException
		{
			js.executeScript("arguments[0].scrollIntoView(true)", buyNow);
			Thread.sleep(20000);
			buyNow.click();
//			wait = new WebDriverWait(driver,20);
//			wait.until(ExpectedConditions.elementToBeClickable(buyNow)).click();
		}
		
		public void closeCheckoutPopup()
		{
			buynow_close_icon.click();
		}
}
