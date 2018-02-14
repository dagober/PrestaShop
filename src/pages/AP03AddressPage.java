package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.WaitTypes;

public class AP03AddressPage {
	
	WebDriver driver;
	WaitTypes wt;
	JavascriptExecutor jse;
	
	By proceedToCheckout = By.name("processAddress");
	
	public AP03AddressPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void AP03ProceedToCheckout(){
		wt = new WaitTypes(driver);
		wt.clickWhenReady(proceedToCheckout, 3);
	}
	
	

}
