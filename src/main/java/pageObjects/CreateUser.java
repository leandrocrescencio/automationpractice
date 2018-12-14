package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;
import utils.StaticValues;

public class CreateUser {
	
	private WebDriver driver;
	
	public CreateUser(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountInput() {
		return WebUtils.elementWait(driver, By.id("create-account_form"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCreatAccountEmailInput() {
		return WebUtils.elementWait(driver, By.id("email_create"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCreateAccountButton() {
		return WebUtils.clickWait(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), StaticValues.TIMEOUT);
	}
	
	public void setCreateAccountEmailInput(String email) {
		WebElement element = this.getCreatAccountEmailInput();
		element.clear();
		element.sendKeys(email);
	}

}