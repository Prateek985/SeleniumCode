package Selenium_FrameWork.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Abstract_Component{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(id=".action_submit")
	WebElement submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2])")
	WebElement SelectCountry;
	
	By result = By.cssSelector(".ta-results");
	
	public void selectCountry(String CountryName)
	{

	    Actions a = new Actions(driver);
		a.sendKeys(SelectCountry, CountryName).build().perform();
		waitForElementToAppear(result);
		SelectCountry.click();	
	}
	
	public void SubmitOrder()  
	{
		submit.click();
		
		
	}
	

}
