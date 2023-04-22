package Selenium_FrameWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium_FrameWork.pagefactory.CartPage;
import Selenium_FrameWork.pagefactory.CheckOutPage;
import Selenium_FrameWork.pagefactory.LandingPage;
import Selenium_FrameWork.pagefactory.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landpage = new LandingPage(driver);
		landpage.LoginPage("prateekchouhan91@gmail.com", "Mobile@123");
		
	//	driver.findElement(By.id("userEmail")).sendKeys("prateekchouhan91@gmail.com");
	//	driver.findElement(By.id("userPassword")).sendKeys("Mobile@123");
	//	driver.findElement(By.id("login")).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		ProductCatalog pro = new ProductCatalog(driver);
		List<WebElement>products = pro.getProductList();
		//pro.addProductToCart(productName);
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//System.out.println(products);
		
		//WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		pro.goToCartPage();
		//driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		/*
		 //*[@class='cartSection']/h3 this is a parent to child traverse this is xpath
		 */
		
		//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		 //Boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		
		CartPage cartpage = new CartPage(driver);
		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	    //driver.findElement(By.cssSelector(".totalRow button")).click();
		cartpage.goToCheckOut();
		
	    /*
	    Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2])")).click();
		driver.findElement(By.cssSelector(".action_submit")).click();
		*/
		
		CheckOutPage checkout = new CheckOutPage(driver);
		checkout.selectCountry("India");
		checkout.SubmitOrder();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
