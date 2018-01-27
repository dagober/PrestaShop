package basicTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Login {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/home/daithi/workspace/selenium/geckodriver");
		baseUrl= "http://automationpractice.com/index.php";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deuve82@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4r");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(4000);
		
		WebElement buttonElement = driver.findElement(By.xpath("//a[@title='Log me out']"));
		String elementText = buttonElement.getText();
		System.out.println("Name of the element: " + elementText);
		assertEquals(elementText, "Sign out");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
