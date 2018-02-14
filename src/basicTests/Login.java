package basicTests;

import org.testng.annotations.Test;

import utilities.Screenshots;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Login {

	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/home/daithi/workspace/selenium/geckodriver");
		baseUrl = "http://automationpractice.com/index.php";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deuve82@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4d");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(4000);
		
		WebElement buttonElement = null;

		try {
			buttonElement = driver.findElement(By.xpath("//a[@title='Log me out']"));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		String elementText = buttonElement.getText();
		System.out.println("Name of the element: " + elementText);
		assertEquals(elementText, "Sign out");
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			//String imagePath = test.addScreenCapture(path);
			System.out.println("Failed test, screenshot taken: " + path);
			driver.quit();

		}
	}

}
