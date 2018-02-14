package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitTypes;

public class APLoginPage {
	
	WebDriver driver;
	WaitTypes wt;

	By emailPractice = By.xpath("//input[@id='email']");
	By passPractice = By.xpath("//input[@id='passwd']");
	By submitLoginPractice = By.xpath("//button[@id='SubmitLogin']");
	By logoutButtonPractice = By.xpath("//a[@title='Log me out']");
	By tshirtsCategoriePractice = By.xpath("//div[@id='block_top_menu']/ul/li[3]/a");
	By loginAccountNamePractice = By.className("account");
	
	
	public APLoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setEmail(String strEmail){
		wt = new WaitTypes(driver);
		WebElement emailField = wt.waitForElement(emailPractice, 3);
		emailField.sendKeys(strEmail);
		//driver.findElement(emailPractice).sendKeys(strEmail);
	}
	
	public void setPass(String strPass){
		driver.findElement(passPractice).sendKeys(strPass);
	}
	
	public void clicksubmitLoginButton(){
		driver.findElement(submitLoginPractice).click();
	}
	
	public void clickLogoutButton(){
		driver.findElement((logoutButtonPractice)).click();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public String getAccountName(){
		wt = new WaitTypes(driver);
		wt.waitForElement(loginAccountNamePractice, 3);
		return driver.findElement(loginAccountNamePractice).getText();
	}
	
	public void loginToAutomationPractice(String strEmail, String strPass) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		this.setEmail(strEmail);
		this.setPass(strPass);
		this.clicksubmitLoginButton();
		 wait.until(ExpectedConditions.titleContains("My account"));
		//Thread.sleep(4000);
	}
	
	public void logoutFromAutomationPractice(){
		this.clickLogoutButton();
	}
	
	public void clickOnTShirtsCategory() throws InterruptedException{
		wt = new WaitTypes(driver);
		wt.clickWhenReady(tshirtsCategoriePractice, 3);
		//driver.findElement(tshirtsCategoriePractice).click();
		System.out.println("after finding&click tshirtsCategoriePractice");
		//Thread.sleep(4000);
	}

}
