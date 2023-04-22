package Selenium_Framework1.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import Selenium_FrameWork.pagefactory.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver InitilizeTest() throws IOException
	{
		
		//In java we have a properties files in that we will set one properties file and we will decide in which browser our frame work will be executing test cases 
		//system.getproperty will get the location dynamically for the other system machine and we are not hardcoding our local system paths we are making it dynamic
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("E:\\\\Java Project\\\\Sun_project\\\\Selenium_FrameWork")+"\\src\\test\\java\\Selenium_FrameWork2\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			//firefox
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			//edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeTest
	public LandingPage LaunchApplication() throws IOException 
	{
		driver = InitilizeTest();
		LandingPage landpage = new LandingPage(driver);
		landpage.LoginPage("prateekchouhan91@gmail.com", "Mobile@123");
		landpage.goTo();
		return landpage;
		
	}

}
