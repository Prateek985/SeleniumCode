package Selenium_FrameWork.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog extends Abstract_Component{

WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{  
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//pageFactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".card-body button:last-of-type");
	By toastcontainer = By.cssSelector("div#toast-container");
	
	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productsBy);
		return products;
		
	}

	public WebElement getProductByname(String productName)
	{
		
        WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		return prod;
		
	}
	
	public WebElement addProductToCart(String productName) throws InterruptedException
	{
		
		WebElement prod = getProductByname(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToAppear(toastcontainer);
		waitForElementToDisAppear(animation);
		return prod;
		
	}
	
	
	

}
