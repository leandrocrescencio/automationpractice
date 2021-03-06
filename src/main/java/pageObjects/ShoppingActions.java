package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class ShoppingActions {
	
	private WebDriver driver;
	
	public ShoppingActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAddToCartButton() {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"));
	}
	
	public WebElement getAddedToCartModal() {
		return WebUtils.elementWait(driver, By.id("layer_cart"));
	}
	
	public WebElement getContinueShopingButton() {
		return WebUtils.clickWait(driver, By.xpath("//span[@title=\"Continue shopping\"]"));
	}
	
	public WebElement getProceedToCheckoutButton() {
		return WebUtils.clickWait(driver, By.xpath("//span[contains(text(), \"Proceed to checkout\")]"));
	}
	
	public WebElement getSuccessfullyAddedMessage() {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
	}
}