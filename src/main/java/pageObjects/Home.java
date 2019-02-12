package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class Home {
	
	private WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInButton() {
		return WebUtils.clickWait(driver, By.xpath("//a[contains(text(), \"Sign in\")]"));
	}
	
	public WebElement getHomePageSlider() {
		return WebUtils.elementWait(driver, By.id("homepage-slider"));
	}
	
	public WebElement getContainerPopular() {
		return WebUtils.elementWait(driver, By.id("homefeatured"));
	}
	
	public WebElement getFooterBaners() {
		return WebUtils.elementWait(driver, By.id("htmlcontent_home"));
	}	
}