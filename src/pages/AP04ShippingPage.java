package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.WaitTypes;

public class AP04ShippingPage {
	WebDriver driver;
	WaitTypes wt;
	JavascriptExecutor jse;
	
	By tncCheckBox = By.xpath("//input[@type='checkbox']");
	By proceedToCheckOut = By.name("processCarrier");
	
	public AP04ShippingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void AP04TickCheckBox(){
		wt = new WaitTypes(driver);
		wt.clickWhenReady(tncCheckBox, 3);
		driver.findElement(tncCheckBox).click();
	}
	
	public void AP04ProceedToCheckout(){
		driver.findElement(proceedToCheckOut).click();
	}
}
