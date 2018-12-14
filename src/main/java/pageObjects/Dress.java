package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;
import utils.StaticValues;

public class Dress {
	
	private WebDriver driver;
	
	public Dress(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getWomenButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getDressesButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getTShirtsButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getDressesDropDown() {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCasualDressesButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getEveningDressesButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getSummerDressesButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), StaticValues.TIMEOUT);
	}
	
	/**@parametro  pra dressNum 1 ao 3 */
	public WebElement getDress(int dressNum) {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), StaticValues.TIMEOUT);
	}		
		
	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));	
	}
}