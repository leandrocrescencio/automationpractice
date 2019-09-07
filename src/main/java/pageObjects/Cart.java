package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class Cart {
	
	private WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartTab() {
		return WebUtils.elementWait(driver, By.xpath("//b[contains(text(), \"Cart\")]/.."));
	}
	
	public WebElement getCartEmpty() {
		return WebUtils.elementWait(driver, By.xpath("//p[@class=\"cart_block_no_products unvisible\"]"));
	}
	
	public WebElement getCartProducts(int productNum) {
		return WebUtils.elementWait(driver, By.xpath("//dt[" + productNum + "]"));
	}
	
	public WebElement getCartProductsQty(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//dt[" + numOfProduct + "]//span[@class=\"quantity\"]"));
	}
	
	public WebElement getCartProductPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//dt[" + numOfProduct + "]//span[@class=\"price\"]"));
	}
	
	public WebElement getCartShipingCost() {
		return WebUtils.elementWait(driver, By.xpath("//div[@class=\"cart-prices\"]//span[contains(.,\"$2.00\")]"));
	}
	
	public WebElement getCartTotalPrice() {
		return WebUtils.elementWait(driver, By.xpath("//span[@class=\"price cart_block_total ajax_block_cart_total\"]"));
	}
	
	public WebElement getCartTabCheckOutButton() {
		return WebUtils.clickWait(driver, By.xpath("//a[@id=\"button_order_cart\"]/span[contains(text(), \"Check out\")]"));
	}
	
	public List<WebElement> getCartTotalProductsQty() {
		return driver.findElements(By.xpath("//dt"));
	}
}