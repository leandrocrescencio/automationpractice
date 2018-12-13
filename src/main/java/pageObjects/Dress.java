package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.ElementUtils;

public class Dress {
	
	private WebDriver driver;
	
	public Dress(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getWomenBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 30);
	}
	
	public WebElement getDressesBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 30);
	}
	
	public WebElement getTShirtsBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 30);
	}
	
	public WebElement getDressesDropDown() {
		return ElementUtils.elementWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), 30);
	}
	
	public WebElement getCasualDressesBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), 30);
	}
	
	public WebElement getEveningDressesBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), 30);
	}
	
	public WebElement getSummerDressesBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 30);
	}
	
	/**@param dressNum (value 1) */
	public WebElement getCasualDressProduct(int dressNum) {
		return ElementUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}
	
	/**@param dressNum (value 1) */
	public WebElement getEveningDressProduct(int dressNum) {
		return ElementUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}
	
	/**@param dressNum (values from 1 to 3) */
	public WebElement getSummerDressProduct(int dressNum) {
		return ElementUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}
	
	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));	
	}
}