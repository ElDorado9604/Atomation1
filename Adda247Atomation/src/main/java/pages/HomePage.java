package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@FindBy (xpath = "//div[text() = 'Signup/Login']")
	private WebElement loginOption;
	
	@FindBy (xpath = "(//button[@class='dropbtn']//img)[2]")
	private WebElement account;
	
	@FindBy (xpath = "(//div[@class='login-rightside-list']//a)[3]")
	private WebElement logoutBtn;
	
	@FindBy (xpath = "//div[text()='All Courses ']")
	private WebElement allCoursesList ;
	
	@FindBy (xpath = "//li[@data-id='2']")
	private WebElement sscCourse ;
	
	@FindBy (xpath = "//a[text()='SSC CGL']")
	private WebElement sscCGL ;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		act = new Actions(driver);
	}
	
	public void clickOnLoginOption(){
		loginOption.click(); 
	}
	
	public void clickOnAccountTab() 
	{
		//js.executeScript("arguments[0].click();", account);
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(account)).click();
	}
	
	public void clickOnLogoutBtn()
	{
		act.moveToElement(logoutBtn).click().build().perform();
	}
	
	public void moveToAllCoursesList(){
		act.moveToElement(allCoursesList).perform();
	}
	public void moveToSSC_Course(){
		act.moveToElement(sscCourse);
	}
	public void moveT0SSC_CGL_AndClick(){
		act.moveToElement(sscCGL).click().build().perform();
	}
	public void clickONsscCGL() {
		act.moveToElement(allCoursesList).click().build().perform();
		act.moveToElement(sscCourse).click().build().perform();
		act.moveToElement(sscCGL).click().build().perform();
	}	
}
