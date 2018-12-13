package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commom.ElementUtils;

public class CreateUserForm {
	
	private WebDriver driver;
	
	public CreateUserForm(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getAccountCreationForm() {
		return ElementUtils.elementWait(driver, By.id("account-creation_form"), 30);
	}
	
	public WebElement getCustomerTitleMr() {
		return ElementUtils.clickWait(driver, By.id("uniform-id_gender1"), 30);
	}
	
	public WebElement getCustomerTitleMrs() {
		return ElementUtils.clickWait(driver, By.id("uniform-id_gender2"), 30);
	}
	
	public WebElement getCustomerFirstNameField() {
		return ElementUtils.elementWait(driver, By.id("customer_firstname"), 30);
	}
	
	public WebElement getCustomerLastNameField() {
		return ElementUtils.elementWait(driver, By.id("customer_lastname"), 30);
	}
	
	public WebElement getCustomerEmailField() {
		return ElementUtils.elementWait(driver, By.id("email"), 30);
	}
	
	public WebElement getCustomerPasswordField() {
		return ElementUtils.elementWait(driver, By.id("passwd"), 30);
	}
	
	public Select selectCustomerDateOfBirthDay() {
		WebElement dayOfBirth = ElementUtils.elementWait(driver, By.id("days"), 30);
		return new Select(dayOfBirth);
	}

	public Select selectCustomerDateOfBirthMonth() {
		WebElement monthOfBirth = ElementUtils.elementWait(driver, By.id("months"), 30);
		return new Select(monthOfBirth);
	}
		
	public Select selectCustomerDateOfBirthYear() {
		WebElement yearOfBirth = ElementUtils.elementWait(driver, By.id("years"), 30);
		return new Select(yearOfBirth);
	}
	
	public WebElement getFirstNameField() {
		return ElementUtils.elementWait(driver, By.id("firstname"), 30);
	}
	
	public WebElement getLastNameField() {
		return ElementUtils.elementWait(driver, By.id("lastname"), 30);
	}
	
	public WebElement getCompanyField() {
		return ElementUtils.elementWait(driver, By.id("company"), 30);
	}
	
	public WebElement getAddressField() {
		return ElementUtils.elementWait(driver, By.id("address1"), 30);
	}
	
	public WebElement getAddressFieldTwo() {
		return ElementUtils.elementWait(driver, By.name("address2"), 30);
	}
	
	public WebElement getCity() {
		return ElementUtils.elementWait(driver, By.id("city"), 30);
	}
	
	public Select selectCountry() {
		WebElement country = ElementUtils.elementWait(driver, By.id("id_country"), 30);
		return new Select(country);
	}
	
	public Select selectState() {
		WebElement state = ElementUtils.elementWait(driver, By.id("id_state"), 30);
		return new Select(state);
	}
	
	public WebElement getPostalCodeField() {
		return ElementUtils.elementWait(driver, By.id("postcode"), 30);
	}
	
	public WebElement getAdditionalInformationField() {
		return ElementUtils.elementWait(driver, By.id("other"), 30);
	}
	
	public WebElement getHomePhoneField() {
		return ElementUtils.elementWait(driver, By.id("phone"), 30);
	}
	
	public WebElement getMobilePhoneField() {
		return ElementUtils.elementWait(driver, By.id("phone_mobile"), 30);
	}
	
	public WebElement getAddressAliasField() {
		return ElementUtils.elementWait(driver, By.id("alias"), 30);
	}
	
	public WebElement getRegisterBtn() {
		return ElementUtils.clickWait(driver, By.id("submitAccount"), 30);
	}
	
	public WebElement successfullyCreatedAccount() {
		return ElementUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 30);
	}

		
	public void setCustomerTitleMr() {
		this.getCustomerTitleMr().click();
	}
	
	public void setCustomerTitleMrs() {
		this.getCustomerTitleMrs().click();
	}
	
	public void setCustomerFirstNameField(String firstName) {
		WebElement customerFirstNameField = this.getCustomerFirstNameField();
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(firstName);
	}
	
	public void setCustomerLastNameField(String lastName) {
		WebElement customerLastNameField = this.getCustomerLastNameField();
		customerLastNameField.clear();
		customerLastNameField.sendKeys(lastName);
	}
	
	public void setCustomerEmailField(String email) {
		WebElement customerEmailField = this.getCustomerEmailField();
		customerEmailField.clear();
		customerEmailField.sendKeys(email);
	}
	
	public void setCustomerPasswordField(String password) {
		WebElement customerPasswordField = this.getCustomerPasswordField();
		customerPasswordField.clear();
		customerPasswordField.sendKeys(password);
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
	
	public void setCompanyField(String company) {
		WebElement companyField = this.getCompanyField();
		companyField.clear();
		companyField.sendKeys(company);
	}
	
	public void setAddressField(String address) {
		WebElement addressField = this.getAddressField();
		addressField.clear();
		addressField.sendKeys(address);
	}
	
	public void setAddressFieldTwo(String addresTwo) {
		WebElement addresField = this.getAddressFieldTwo();
		addresField.clear();
		addresField.sendKeys(addresTwo);
	}
	
	public void setCityField(String city) {
		WebElement cityField = this.getCity();
		cityField.clear();
		cityField.sendKeys(city);
	}
	
	public void selectState(String state) {
		Select selectState = this.selectState();
		selectState.selectByValue(state);
	}
	
	public void setPostalCodeField(String zip) {
		WebElement postalCode = this.getPostalCodeField();
		postalCode.clear();
		postalCode.sendKeys(zip);
	}
	
	public void selectCountry(String country) {
		Select selectCountry = this.selectCountry();
		selectCountry.selectByVisibleText(country);
	}
	
	public void setAdditionalInfo(String info) {
		WebElement additionalInfo = this.getAdditionalInformationField();
		additionalInfo.clear();
		additionalInfo.sendKeys(info);
	}
	
	public void setHomePhoneField(String phone) {
		WebElement homePhone = this.getHomePhoneField();
		homePhone.clear();
		homePhone.sendKeys(phone);
	}
	
	public void setMobilePhoneField(String phone) {
		WebElement mobilePhone = this.getMobilePhoneField();
		mobilePhone.clear();
		mobilePhone.sendKeys(phone);
	}
	
	public void setAddressAliasField(String alias) {
		WebElement addressAlias = this.getAddressAliasField();
		addressAlias.clear();
		addressAlias.sendKeys(alias);
	}
	
	public WebElement getErrorPanel() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"You must register\")]/../.."), 30);
	}
	
	public WebElement getPhoneNumberError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"You must register at least one phone number.\")]"), 30);
	}
	
	public WebElement getHomePhoneInvalidError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone\")]"), 30);
	}
	
	public WebElement getMobilePhoneInvalidError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone_mobile\")]"), 30);
	}
	
	public WebElement getLastNameError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"lastname\")]"), 30);
	}
	
	public WebElement getLastNameInvalidError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"lastname\")]"), 30);
	}
	
	public WebElement getFirstNameError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"firstname\")]"), 30);
	}
	
	public WebElement getFirstNameInvalidError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"firstname\")]"), 30);
	}
	
	public WebElement getEmailRequiredError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"lastname\")]"), 30);
	}
	
	public WebElement getEmailInvalidError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"email\")]"), 30);
	}
	
	public WebElement getEmailBeenRegistered() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"An account using this\")]"), 30);
	}
	
	public WebElement getPasswordRequiredError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"passwd\")]"), 30);
	}
	
	public WebElement getPasswordInvalidError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"passwd\")]"), 30);
	}
	
	public WebElement getCountryRequiredError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"id_country\")]"), 30);
	}
	
	public WebElement getAddressAliasRequiredError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"alias\")]"), 30);
	}
	
	public WebElement getAddressRequiredError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"address1\")]"), 30);
	}
	
	public WebElement getCityRequiredError() {
		return ElementUtils.elementWait(driver, By.xpath("//b[contains(text(), \"city\")]"), 30);
	}
	
	public WebElement getCountryUnselectedError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"Country is invalid\")]"), 30);
	}
	
	public WebElement getStateRequredError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"This country requires you to choose a State.\")]"), 30);
	}
	
	public WebElement getPostalCodeError() {
		return ElementUtils.elementWait(driver, By.xpath("//li[contains(text(), \"The Zip/Postal code you\")]"), 30);
	}
	
	public WebElement getFirstNameHighlightedGreen() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_firstname\"]"), 30);
	}
	
	public WebElement getFirstNameHighlightedRed() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_firstname\"]"), 30);
	}
	
	public WebElement getLastNameHighlightedGreen() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_lastname\"]"), 30);
	}
	
	public WebElement getLastNameHighlightedRed() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_lastname\"]"), 30);
	}
	
	public WebElement getEmailHighlightedGreen() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"email\"]"), 30);
	}
	
	public WebElement getEmailHighlightedRed() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"email\"]"), 30);
	}
	
	public WebElement getPasswordHighlightedGreen() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required password form-group form-ok\"]//input[@id=\"passwd\"]"), 30);
	}
	
	public WebElement getPasswordHighlightedRed() {
		return ElementUtils.elementWait(driver, By.xpath("//div[@class=\"required password form-group form-error\"]//input[@id=\"passwd\"]"), 30);
	}
	
}