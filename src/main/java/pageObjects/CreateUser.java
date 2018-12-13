package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.ElementUtils;

public class CreateUser {
	
	private WebDriver driver;
	
	public CreateUser(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return ElementUtils.elementWait(driver, By.id("create-account_form"), 30);
	}
	
	public WebElement getCreatAccountEmailField() {
		return ElementUtils.elementWait(driver, By.id("email_create"), 30);
	}
	
	public WebElement getCreateAccountBtn() {
		return ElementUtils.clickWait(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	
	public void setCreateAccountEmailField(String email) {
		WebElement element = this.getCreatAccountEmailField();
		element.clear();
		element.sendKeys(email);
	}
	
	public WebElement getEmailErrorMessage() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public WebElement getEmailBeenRegistered() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 30);
	}
}