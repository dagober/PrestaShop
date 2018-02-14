package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.WaitTypes;

public class AP01SummaryPage {
	WebDriver driver;
	WaitTypes wt;
	JavascriptExecutor jse;
	
	By proceedToCheckout = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
	By totalPrice = By.id("total_price");
	
	public AP01SummaryPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String totalPrice(){
		wt = new WaitTypes(driver);
		wt.waitForElement(totalPrice, 3);
		return driver.findElement(totalPrice).getText();
	}
	
	public void AP01ProceedToCheckoutClick(){
		driver.findElement(proceedToCheckout).click();
	}
	
	

}
