package ExtendReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExtendDemoReport {

	@Test
	public void initialDemo()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println("My name is prateek");
		System.out.println("My name is prateek");
		System.out.println("My name is prateek");
	}
	  
	
}
