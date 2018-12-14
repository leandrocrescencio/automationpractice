package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;
import utils.StaticValues;

public class SignInInput {
	
	private WebDriver driver;
	
	public SignInInput(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInInput() {
		return WebUtils.elementWait(driver, By.id("login_form"), StaticValues.TIMEOUT);
	}
	
	public WebElement getSignInEmailInput() {
		return WebUtils.elementWait(driver, By.id("email"), StaticValues.TIMEOUT);
	}
	
	public WebElement getSignInPasswordInput() {
		return WebUtils.elementWait(driver, By.id("passwd"), StaticValues.TIMEOUT);
	}
	
	public WebElement getSignInBtn() {
		return WebUtils.elementWait(driver, By.id("SubmitLogin"), StaticValues.TIMEOUT);
	}
	
	public void setEmailInput(String mail) {
		WebElement email = this.getSignInEmailInput();
		email.clear();
		email.sendKeys(mail);
	}
	
	public void setPasswordInput(String pass) {
		WebElement password = this.getSignInPasswordInput();
		password.clear();
		password.sendKeys(pass);
	}
	

}