package Selenium_FrameWork.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Abstract_Component{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{  
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	//WebElement useremail = driver.findElement(By.id("userEmail"));
	//pageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submitButton;
	
	
	public void LoginPage(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitButton.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
