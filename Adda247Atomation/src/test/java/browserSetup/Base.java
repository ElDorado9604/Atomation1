package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	//Browser related
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\New Program files\\Atomation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openMSEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "D:\\New Program files\\Atomation\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	
}
