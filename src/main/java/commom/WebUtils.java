package commom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.StaticValues;

public class WebUtils {
	
	private WebUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	public static WebElement clickWait(WebDriver driver, By selector) {
		return (new WebDriverWait(driver, StaticValues.TIMEOUT)).until(ExpectedConditions.elementToBeClickable(selector));
	}

	public static WebElement elementWait(WebDriver driver, By selector) {
		return (new WebDriverWait(driver, StaticValues.TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(selector));
	}
	
	public static void titleWait(WebDriver driver, String title){
		 (new WebDriverWait(driver, StaticValues.TIMEOUT)).until(ExpectedConditions.titleIs(title));
	}

}