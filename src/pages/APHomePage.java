package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitTypes;

public class APHomePage {

	WebDriver driver;
	WaitTypes wt;
	By homePageLogin = By.xpath("//a[@class='login']");
	
	public APHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public void clickLogin(){
		wt = new WaitTypes(driver);
		wt.clickWhenReady(homePageLogin, 3);
		//driver.findElement(homePageLogin).click();
	}
}
