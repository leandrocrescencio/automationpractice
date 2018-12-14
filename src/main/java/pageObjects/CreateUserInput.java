package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commom.WebUtils;

public class CreateUserInput {
	
	private WebDriver driver;
	
	public CreateUserInput(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getAccountCreationInput() {
		return WebUtils.elementWait(driver, By.id("account-creation_form"), 30);
	}
	
	public WebElement getCustomerTitleMr() {
		return WebUtils.clickWait(driver, By.id("uniform-id_gender1"), 30);
	}
	
	public WebElement getCustomerTitleMrs() {
		return WebUtils.clickWait(driver, By.id("uniform-id_gender2"), 30);
	}
	
	public WebElement getCustomerFirstNameInput() {
		return WebUtils.elementWait(driver, By.id("customer_firstname"), 30);
	}
	
	public WebElement getCustomerLastNameInput() {
		return WebUtils.elementWait(driver, By.id("customer_lastname"), 30);
	}
	
	public WebElement getCustomerEmailInput() {
		return WebUtils.elementWait(driver, By.id("email"), 30);
	}
	
	public WebElement getCustomerPasswordInput() {
		return WebUtils.elementWait(driver, By.id("passwd"), 30);
	}
	
	public Select selectCustomerDateOfBirthDay() {
		return new Select(WebUtils.elementWait(driver, By.id("days"), 30));
	}

	public Select selectCustomerDateOfBirthMonth() {
		return new Select(WebUtils.elementWait(driver, By.id("months"), 30));
	}
		
	public Select selectCustomerDateOfBirthYear() {
		return new Select(WebUtils.elementWait(driver, By.id("years"), 30));
	}
	
	public WebElement getFirstNameInput() {
		return WebUtils.elementWait(driver, By.id("firstname"), 30);
	}
	
	public WebElement getLastNameInput() {
		return WebUtils.elementWait(driver, By.id("lastname"), 30);
	}
	
	public WebElement getCompanyInput() {
		return WebUtils.elementWait(driver, By.id("company"), 30);
	}
	
	public WebElement getAddressInput() {
		return WebUtils.elementWait(driver, By.id("address1"), 30);
	}
	
	public WebElement getAddressInput2() {
		return WebUtils.elementWait(driver, By.name("address2"), 30);
	}
	
	public WebElement getCity() {
		return WebUtils.elementWait(driver, By.id("city"), 30);
	}
	
	public Select selectCountry() {
		return new Select(WebUtils.elementWait(driver, By.id("id_country"), 30));
	}
	
	public Select selectState() {
		return new Select(WebUtils.elementWait(driver, By.id("id_state"), 30));
	}
	
	public WebElement getPostalCodeInput() {
		return WebUtils.elementWait(driver, By.id("postcode"), 30);
	}
	
	public WebElement getAdditionalInformationInput() {
		return WebUtils.elementWait(driver, By.id("other"), 30);
	}
	
	public WebElement getHomePhoneInput() {
		return WebUtils.elementWait(driver, By.id("phone"), 30);
	}
	
	public WebElement getMobilePhoneInput() {
		return WebUtils.elementWait(driver, By.id("phone_mobile"), 30);
	}
	
	public WebElement getAddressAliasInput() {
		return WebUtils.elementWait(driver, By.id("alias"), 30);
	}
	
	public WebElement getRegisterBtn() {
		return WebUtils.clickWait(driver, By.id("submitAccount"), 30);
	}
	
	public WebElement successfullyCreatedAccount() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 30);
	}
		
	public void setCustomerTitleMr() {
		this.getCustomerTitleMr().click();
	}
	
	public void setCustomerTitleMrs() {
		this.getCustomerTitleMrs().click();
	}
	
	public void setCustomerFirstNameInput(String firstName) {
		WebElement customerFirstNameInput = this.getCustomerFirstNameInput();
		customerFirstNameInput.clear();
		customerFirstNameInput.sendKeys(firstName);
	}
	
	public void setCustomerLastNameInput(String lastName) {
		WebElement customerLastNameInput = this.getCustomerLastNameInput();
		customerLastNameInput.clear();
		customerLastNameInput.sendKeys(lastName);
	}
	
	public void setCustomerEmailInput(String email) {
		WebElement customerEmailInput = this.getCustomerEmailInput();
		customerEmailInput.clear();
		customerEmailInput.sendKeys(email);
	}
	
	public void setCustomerPasswordInput(String password) {
		WebElement customerPasswordInput = this.getCustomerPasswordInput();
		customerPasswordInput.clear();
		customerPasswordInput.sendKeys(password);
	}
	
	public void selectCustomerDateOfBirthDay(String day) {
		Select dayOfBirth = this.selectCustomerDateOfBirthDay();
		dayOfBirth.selectByValue(day);
	}
	
	public void selectCustomerDateOfBirthMonth(String month) {
		Select monthOfBirth = this.selectCustomerDateOfBirthMonth();
		monthOfBirth.selectByValue(month);
	}
	
	public void selectCustomerDateOfBirthYear(String year) {
		Select yearOfBirth = this.selectCustomerDateOfBirthYear();
		yearOfBirth.selectByValue(year);
	}
	
	public void setCompanyInput(String company) {
		WebElement companyInput = this.getCompanyInput();
		companyInput.clear();
		companyInput.sendKeys(company);
	}
	
	public void setAddressInput(String address) {
		WebElement addressInput = this.getAddressInput();
		addressInput.clear();
		addressInput.sendKeys(address);
	}
	
	public void setAddressInput2(String addresTwo) {
		WebElement addresInput = this.getAddressInput2();
		addresInput.clear();
		addresInput.sendKeys(addresTwo);
	}
	
	public void setCityInput(String city) {
		WebElement cityInput = this.getCity();
		cityInput.clear();
		cityInput.sendKeys(city);
	}
	
	public void selectState(String state) {
		Select selectState = this.selectState();
		selectState.selectByValue(state);
	}
	
	public void setPostalCodeInput(String zip) {
		WebElement postalCode = this.getPostalCodeInput();
		postalCode.clear();
		postalCode.sendKeys(zip);
	}
	
	public void selectCountry(String country) {
		Select selectCountry = this.selectCountry();
		selectCountry.selectByVisibleText(country);
	}
	
	public void setAdditionalInfo(String info) {
		WebElement additionalInfo = this.getAdditionalInformationInput();
		additionalInfo.clear();
		additionalInfo.sendKeys(info);
	}
	
	public void setHomePhoneInput(String phone) {
		WebElement homePhone = this.getHomePhoneInput();
		homePhone.clear();
		homePhone.sendKeys(phone);
	}
	
	public void setMobilePhoneInput(String phone) {
		WebElement mobilePhone = this.getMobilePhoneInput();
		mobilePhone.clear();
		mobilePhone.sendKeys(phone);
	}
	
	public void setAddressAliasInput(String alias) {
		WebElement addressAlias = this.getAddressAliasInput();
		addressAlias.clear();
		addressAlias.sendKeys(alias);
	}

		
}