package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollXY {
	
	WebDriver driver;
	static JavascriptExecutor jse;
	
	public ScrollXY(WebDriver driver){
		this.driver = driver;
	}
	
	public static void scrollPage(int intScrollX, int intScrollY, WebDriver driver) throws InterruptedException{
		String scrollXY = "window.scrollBy(" + intScrollX + ", " + intScrollY + ")";
		jse = (JavascriptExecutor)driver;
		jse.executeScript(scrollXY);
		//Thread.sleep(4000);
	}

}
