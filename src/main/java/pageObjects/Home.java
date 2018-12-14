package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;
import utils.StaticValues;

public class Home {
	
	private WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInBtn() {
		return WebUtils.clickWait(driver, By.xpath("//a[contains(text(), \"Sign in\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getHomePageSlider() {
		return WebUtils.elementWait(driver, By.id("homepage-slider"), StaticValues.TIMEOUT);
	}
	
	public WebElement getContainerPopular() {
		return WebUtils.elementWait(driver, By.id("homefeatured"), StaticValues.TIMEOUT);
	}
	
	public WebElement getFooterBaners() {
		return WebUtils.elementWait(driver, By.id("htmlcontent_home"), StaticValues.TIMEOUT);
	}	
}