package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSC_CGL_coursePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath= "//a[text()='SSC CGL  Test Series ']")
	private WebElement sscCGL_TestSeries ;
	
	@FindBy (xpath= "//a[text()='SSC CGL  Online Live Classes ']")
	private WebElement sscCGL_LiveCourse ;
	
	@FindBy (xpath= "//a[text()='SSC CGL  Video Courses ']")
	private WebElement sscCGL_VideoCourse ;
	
	@FindBy (xpath= "//a[text()='SSC CGL  E-Books ']")
	private WebElement sscCGL_Ebooks ;
	
	@FindBy (xpath= "//a[text()='SSC CGL  Books ']")
	private WebElement sscCGL_Books ;
	
	public SSC_CGL_coursePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnsscCGL_TestSeries(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(sscCGL_TestSeries)).click();
	}
	public void clickOnsscCGL_LiveCourse(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(sscCGL_LiveCourse)).click();
	}
	public void clickOnsscCGL_VideoCourse(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(sscCGL_VideoCourse)).click();
	}
	public void clickOnsscCGL_Ebooks(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(sscCGL_Ebooks)).click();
	}
	public void clickOnsscCGL_Books(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(sscCGL_Books)).click();
	}
}
