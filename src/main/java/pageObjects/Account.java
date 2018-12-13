package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.ElementUtils;

public class Account {
	
	private WebDriver driver;
	
	public Account(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAccountBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//a[@title=\"View my customer account\"]"), 30);
	}
	
	public WebElement getAccountLogout() {
		return ElementUtils.clickWait(driver, By.xpath("//a[@title=\"Log me out\"]"), 30);
	}
	
	public WebElement getAccountOrderHistoryBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//span[contains(text(), \"Order history and details\")]"), 30);
	}
	
	public WebElement getAccountOrderListTable() {
		return ElementUtils.clickWait(driver, By.xpath("//table[@id=\"order-list\"]"), 30);
	}
	
	public List<WebElement> getAccountOrdersLis() {
		return driver.findElements(By.xpath("//table[@id=\"order-list\"]/tbody/tr"));
	}
}