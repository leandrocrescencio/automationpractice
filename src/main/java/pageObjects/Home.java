package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.ElementUtils;

public class Home {
	
	private WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//a[contains(text(), \"Sign in\")]"), 30);
	}
	
	public WebElement getHomePageSlider() {
		return ElementUtils.elementWait(driver, By.id("homepage-slider"), 30);
	}
	
	public WebElement getContainerPopular() {
		return ElementUtils.elementWait(driver, By.id("homefeatured"), 30);
	}
	
	public WebElement getFooterBaners() {
		return ElementUtils.elementWait(driver, By.id("htmlcontent_home"), 30);
	}	
}