package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProceedToCheckout{

	public void ProceedToCheckoutClick(WebDriver driver, By element){
		driver.findElement(element).click();
	}
}