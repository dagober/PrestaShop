package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilities.WaitTypes;


public class APOverlayPage {
	WebDriver driver;
	WaitTypes wt;
	
	By ProceedToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");
	By itemsInCart = By.xpath("//span[@class='ajax_cart_product_txt ']");
	
	public APOverlayPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String itemsInCartLabel(){
		wt = new WaitTypes(driver);
		wt.waitForElement(ProceedToCheckoutButton, 3);
		String strItemsInCart = driver.findElement(itemsInCart).getText().trim();
		return strItemsInCart;
	}
	
	
	public void proceedToCheckoutButtonClick() throws InterruptedException{
		driver.findElement(ProceedToCheckoutButton).click();
		//Thread.sleep(3000);
	}
	
	
}
