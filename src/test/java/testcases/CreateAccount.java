package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class CreateAccount extends BaseTest {

	@Test(priority = 1, description="Create New User Account")
	public void createNewUser() {
		homepage.getSignInButton().click();

		Assert.assertTrue(createAccount.getCreateAccountInput().isDisplayed());
		Assert.assertTrue(createAccount.getCreatAccountEmailInput().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountButton().isDisplayed());
		Assert.assertTrue(signin.getSignInInput().isDisplayed());
		createAccount.setCreateAccountEmailInput(PropertiesUtils.getValue("email"));
		createAccount.getCreateAccountButton().click();
		Assert.assertTrue(createAccountInput.getAccountCreationInput().isDisplayed());
	
		createAccountInput.setCustomerFirstNameInput(PropertiesUtils.getValue("firstname"));
		createAccountInput.setCustomerLastNameInput(PropertiesUtils.getValue("lastname"));
		createAccountInput.setCustomerEmailInput(PropertiesUtils.getValue("email"));
		createAccountInput.setCustomerPasswordInput(PropertiesUtils.getValue("pass"));
		createAccountInput.getAccountCreationInput().click();		
	

		createAccountInput.selectCustomerDateOfBirthDay("6");
		createAccountInput.selectCustomerDateOfBirthMonth("3");
		createAccountInput.selectCustomerDateOfBirthYear("1985");	
		createAccountInput.setPostalCodeInput("12345");
		createAccountInput.setHomePhoneInput("55");
		createAccountInput.setMobilePhoneInput("51999887720");
		createAccountInput.setAddressInput("Rua");
		createAccountInput.setCityInput("Santa Cecilia");
		createAccountInput.selectState("7");
		createAccountInput.setPostalCodeInput("12345");
		createAccountInput.setHomePhoneInput("55");
		createAccountInput.setMobilePhoneInput("51999887720");
		createAccountInput.setAddressAliasInput("HOME");
		createAccountInput.getRegisterButton().click();

		Assert.assertTrue(createAccountInput.successfullyCreatedAccount().isDisplayed());
	}
}