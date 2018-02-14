package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.WaitTypes;

public class AP05PaymentPage {
	
	WebDriver driver;
	WaitTypes wt;
	JavascriptExecutor jse;
	
	By paymentBankwire = By.className("bankwire");
	By confirmOrderButton = By.xpath("//button[@type='submit']/span/i[@class='icon-chevron-right right']");
	By AP05PaymentMethodConfirmation = By.className("page-subheading");
	By totalPrice = By.id("total_price");
	By totalPriceAfterPaymentSelection = By.id("amount");
	By totalPriceAfterPurchase = By.xpath("//span[@class='price']/strong");
	
	public AP05PaymentPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void AP05PaymentByBankwire(){
		driver.findElement(paymentBankwire).click();
	}
	
	public String AP05PaymentMethodConfirmation(){
		return driver.findElement(AP05PaymentMethodConfirmation).getText().trim().toLowerCase();
	}
	
	public String totalPrice(){
		wt = new WaitTypes(driver);
		wt.waitForElement(totalPrice, 3);
		return driver.findElement(totalPrice).getText();
	}
	
	public String totalPriceAfterPaymentSelection(){
		wt = new WaitTypes(driver);
		wt.waitForElement(totalPriceAfterPaymentSelection, 3);
		return driver.findElement(totalPriceAfterPaymentSelection).getText();
	}
	
	public String totalPriceAfterPurchase(){
		wt = new WaitTypes(driver);
		wt.waitForElement(totalPriceAfterPurchase, 3);
		System.out.println("Inside: " + driver.findElement(totalPriceAfterPurchase).getText());
		return driver.findElement(totalPriceAfterPurchase).getText();
	}
	
	public void AP05ConfirmOrderButtonClick() throws InterruptedException{
		//Thread.sleep(4000);
		driver.findElement(confirmOrderButton).click();
	}

}
