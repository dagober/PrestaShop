package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ScrollXY;
import utilities.WaitTypes;

public class APTShirtsCategoryPage {
	WebDriver driver;
	WaitTypes wt;
	
	By fadedShortSleeveTShirts = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
	By addToCart = By.xpath("//a[@title='Add to cart']");
	By catalog = By.xpath("//div[@id='layered_block_left']//p[text()='CATALOG'");
	
	public APTShirtsCategoryPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void APMoveToTShirtsElement() throws InterruptedException{
		wt = new WaitTypes(driver);
		wt.waitForElement(catalog, 3);
		
		ScrollXY.scrollPage(0,700, driver);
		WebElement mainElement = wt.waitForElement(fadedShortSleeveTShirts, 3);
		System.out.println("Element found");
		//WebElement mainElement = driver.findElement(fadedShortSleeveTShirts);
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		System.out.println("After APMoveToTShirtsElement performed");
		//Thread.sleep(2000);
	}
	
	public void APMoveToAddToCartElementClick(){
		WebElement subElement = driver.findElement(addToCart);
		Actions action = new Actions(driver);
		action.moveToElement(subElement).click().perform();
	}
	
	public void APAddToCartElement() throws InterruptedException{
		System.out.println("Before APMoveToTShirtsElement");
		this.APMoveToTShirtsElement();
		System.out.println("After APMoveToTShirtsElement");
		this.APMoveToAddToCartElementClick();
		//Thread.sleep(2000);
	}

}
