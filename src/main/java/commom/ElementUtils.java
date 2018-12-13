package commom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	private ElementUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	public static WebElement clickWait(WebDriver driver, By selector, int waitInterval) {
		return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
	}

	public static WebElement elementWait(WebDriver driver, By selector, int waitInterval) {
		return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
	}
	
	public static void titleWait(WebDriver driver, String title, int waitInterval){
		 (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}

}