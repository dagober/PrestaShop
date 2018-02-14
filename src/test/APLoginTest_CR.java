package test;

import org.testng.annotations.Test;

import pages.AP01SummaryPage;
import pages.AP03AddressPage;
import pages.AP04ShippingPage;
import pages.AP05PaymentPage;
import pages.APHomePage;
import pages.APLoginPage;
import pages.APOverlayPage;
import pages.APTShirtsCategoryPage;
import utilities.Screenshots;
import utilities.ScrollXY;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class APLoginTest_CR {
	
	WebDriver driver;
	
	APHomePage objHomePage;
	APLoginPage objLoginPage;
	APTShirtsCategoryPage objAPTShirtsCategoryPage;
	APOverlayPage objAPOverlay;
	AP01SummaryPage objAP01SummaryPage;
	AP03AddressPage objAP03AddressPage;
	AP04ShippingPage objAP04ShippingPage;
	AP05PaymentPage objAP05PaymentPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "/home/daithi/workspace/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void login_with_valid_credentials() throws InterruptedException {
		objHomePage = new APHomePage(driver);
		String homepageTitle = objHomePage.getPageTitle();
		Assert.assertTrue(homepageTitle.toLowerCase().contains("my store"));
		objHomePage.clickLogin();
		
		objLoginPage = new APLoginPage(driver);
		objLoginPage.loginToAutomationPractice("deuve82@gmail.com", "1q2w3e4r");	
		String loginpageTitle = objLoginPage.getPageTitle();
		Assert.assertTrue(loginpageTitle.toLowerCase().contains("my account"));
		
		String loginAccountName = objLoginPage.getAccountName();
		Assert.assertEquals(loginAccountName, "dv dv");
		
		objLoginPage.clickLogoutButton();
		Assert.assertTrue(homepageTitle.toLowerCase().contains("my store"));
	}
	
	@Test
	public void purchase_with_login() throws InterruptedException, IOException{
		objHomePage = new APHomePage(driver);
		objHomePage.clickLogin();
		
		objLoginPage = new APLoginPage(driver);
		objLoginPage.loginToAutomationPractice("deuve82@gmail.com", "1q2w3e4r");
		
		objLoginPage.clickOnTShirtsCategory();
		
		objAPTShirtsCategoryPage = new APTShirtsCategoryPage(driver);
		objAPTShirtsCategoryPage.APAddToCartElement();
		
		objAPOverlay = new APOverlayPage(driver);
		String label = objAPOverlay.itemsInCartLabel();
		Assert.assertEquals(label, "There is 1 item in your cart.");
		objAPOverlay.proceedToCheckoutButtonClick();
		
		objAP01SummaryPage = new AP01SummaryPage(driver);
		String totalPriceSummary = objAP01SummaryPage.totalPrice();
		Assert.assertEquals(totalPriceSummary, "$18.51");
		objAP01SummaryPage.AP01ProceedToCheckoutClick();
		
		objAP03AddressPage = new AP03AddressPage(driver);
		//ScrollXY.scrollPage(0,1000, driver);
		objAP03AddressPage.AP03ProceedToCheckout();
		
		objAP04ShippingPage = new AP04ShippingPage(driver);
		ScrollXY.scrollPage(0,1300, driver);
		objAP04ShippingPage.AP04TickCheckBox();
		objAP04ShippingPage.AP04ProceedToCheckout();
		
		objAP05PaymentPage = new AP05PaymentPage(driver);
		ScrollXY.scrollPage(0,500, driver);
		String totalPricePaymentPage = objAP05PaymentPage.totalPrice();
		Assert.assertEquals(totalPricePaymentPage, totalPriceSummary);
		objAP05PaymentPage.AP05PaymentByBankwire();
		String totalPricePaymentConfirmationPage = objAP05PaymentPage.totalPriceAfterPaymentSelection();
		Assert.assertEquals(totalPricePaymentConfirmationPage, totalPriceSummary);
		
		String paymentMethodConfirmation = objAP05PaymentPage.AP05PaymentMethodConfirmation();
		Assert.assertEquals(paymentMethodConfirmation, "bank-wire payment.");
		objAP05PaymentPage.AP05ConfirmOrderButtonClick();
		String totalPricePaymentPurchasePage = objAP05PaymentPage.totalPriceAfterPurchase();
		System.out.println("TotalPricePaymentPurchasePage: ¦" + totalPricePaymentPurchasePage +"¦");
		Assert.assertEquals(totalPricePaymentPurchasePage, totalPriceSummary);
		
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
