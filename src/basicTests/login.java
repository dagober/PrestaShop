package basicTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class login {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		JavascriptExecutor jse;
		
		System.setProperty("webdriver.gecko.driver", "/home/daithi/workspace/selenium/geckodriver");
		driver = new FirefoxDriver();
		String baseURL = "http://automationpractice.com/index.php";
		jse = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deuve82@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4r");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(4000);


		//driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[@class='sfHoverForce']//a[@title='T-shirts']")).click();
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[3]/a")).click();
		
		Thread.sleep(4000);
		
		jse.executeScript("window.scrollBy(0, 700)");

		Thread.sleep(4000);
		
		WebElement mainElement = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(2000);
		
		WebElement subElement = driver.findElement(By.xpath("//a[@title='Add to cart']"));
		action.moveToElement(subElement).click().perform();
		
		Thread.sleep(2000);
		
		//Overlay
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		
		//Checkout: 01 Summary
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 700)");
		//WebElement e1 = driver.findElement(By.linkText("Proceed to checkout"));
		
		//System.out.println("Element is displayed: " + e1.isDisplayed());
		//System.out.println("Element is enabled: " + e1.isEnabled());
		
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")).click();
		Thread.sleep(600);
		System.out.println("After the second checkout");
		
		//Checkout: 03 Address
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0, 700)");
		driver.findElement(By.name("processAddress")).click();
		
		
		//Checkout: 04 Shipping
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0, 700)");
		
		
		WebElement tncCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		tncCheckBox.click();
			
		driver.findElement(By.name("processCarrier")).click();
		
		//Checkout 05: Payment
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.className("bankwire")).click();
		
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0, 700)");
		driver.findElement(By.xpath("//button[@type='submit']/span/i[@class='icon-chevron-right right']")).click();
		//("//button[text()='I confirm my order']"));
				
	}

}

