package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;
import utils.StaticValues;

public class ShoppingActions {
	
	private WebDriver driver;
	
	public ShoppingActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAddToCartBtn() {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getAddedToCartModal() {
		return WebUtils.elementWait(driver, By.id("layer_cart"), StaticValues.TIMEOUT);
	}
	
	public WebElement getContinueShopingBtn() {
		return WebUtils.clickWait(driver, By.xpath("//span[@title=\"Continue shopping\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getProceedToCheckoutBtn() {
		return WebUtils.clickWait(driver, By.xpath("//span[contains(text(), \"Proceed to checkout\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getSuccessfullyAddedMessage() {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"), StaticValues.TIMEOUT);
	}
}