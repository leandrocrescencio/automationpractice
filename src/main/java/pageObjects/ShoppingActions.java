package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.ElementUtils;

public class ShoppingActions {
	
	private WebDriver driver;
	
	public ShoppingActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAddToCartBtn() {
		return ElementUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"), 30);
	}
	
	public WebElement getAddedToCartModal() {
		return ElementUtils.elementWait(driver, By.id("layer_cart"), 30);
	}
	
	public WebElement getContinueShopingBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//span[@title=\"Continue shopping\"]"), 30);
	}
	
	public WebElement getProceedToCheckoutBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//span[contains(text(), \"Proceed to checkout\")]"), 30);
	}
	
	public WebElement getSuccessfullyAddedMessage() {
		return ElementUtils.elementWait(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"), 30);
	}
}