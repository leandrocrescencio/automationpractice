package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class Account {
	
	private WebDriver driver;
	
	public Account(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAccountButton() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"View my customer account\"]"));
	}
	
	public WebElement getAccountLogout() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Log me out\"]"));
	}
	
	public WebElement getAccountOrderHistoryButton() {
		return WebUtils.clickWait(driver, By.xpath("//span[contains(text(), \"Order history and details\")]"));
	}
	
	public WebElement getAccountOrderListTable() {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"order-list\"]"));
	}
	
	public List<WebElement> getAccountOrdersLis() {
		return driver.findElements(By.xpath("//table[@id=\"order-list\"]/tbody/tr"));
	}
}