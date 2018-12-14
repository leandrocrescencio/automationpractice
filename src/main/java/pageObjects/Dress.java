package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class Dress {
	
	private WebDriver driver;
	
	public Dress(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getWomenBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 30);
	}
	
	public WebElement getDressesBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 30);
	}
	
	public WebElement getTShirtsBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 30);
	}
	
	public WebElement getDressesDropDown() {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), 30);
	}
	
	public WebElement getCasualDressesBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), 30);
	}
	
	public WebElement getEveningDressesBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), 30);
	}
	
	public WebElement getSummerDressesBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 30);
	}
	
	/**@parametro  pra dressNum 1 ao 3 */
	public WebElement getDress(int dressNum) {
		return WebUtils.elementWait(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);
	}		
		
	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));	
	}
}