package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class SignInInput {
	
	private WebDriver driver;
	
	public SignInInput(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInInput() {
		return WebUtils.elementWait(driver, By.id("login_form"));
	}
	
	public WebElement getSignInEmailInput() {
		return WebUtils.elementWait(driver, By.id("email"));
	}
	
	public WebElement getSignInPasswordInput() {
		return WebUtils.elementWait(driver, By.id("passwd"));
	}
	
	public WebElement getSignInButton() {
		return WebUtils.elementWait(driver, By.id("SubmitLogin"));
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