package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class CreateUser {
	
	private WebDriver driver;
	
	public CreateUser(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return WebUtils.elementWait(driver, By.id("create-account_form"), 30);
	}
	
	public WebElement getCreatAccountEmailInput() {
		return WebUtils.elementWait(driver, By.id("email_create"), 30);
	}
	
	public WebElement getCreateAccountBtn() {
		return WebUtils.clickWait(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	
	public void setCreateAccountEmailInput(String email) {
		WebElement element = this.getCreatAccountEmailInput();
		element.clear();
		element.sendKeys(email);
	}

}