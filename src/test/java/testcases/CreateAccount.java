package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class CreateAccount extends BaseTest {

	@Test(priority = 1, description="Create New User Account")
	public void createNewUser() {
		homepage.getSignInBtn().click();

		Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(createAccount.getCreatAccountEmailInput().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(signin.getSignInInput().isDisplayed());
		createAccount.setCreateAccountEmailInput(PropertiesUtils.getValue("email"));
		createAccount.getCreateAccountBtn().click();
		Assert.assertTrue(createAccountForm.getAccountCreationInput().isDisplayed());
	
		createAccountForm.setCustomerFirstNameInput(PropertiesUtils.getValue("firstname"));
		createAccountForm.setCustomerLastNameInput(PropertiesUtils.getValue("lastname"));
		createAccountForm.setCustomerEmailInput(PropertiesUtils.getValue("email"));
		createAccountForm.setCustomerPasswordInput(PropertiesUtils.getValue("pass"));
		createAccountForm.getAccountCreationInput().click();		
	

		createAccountForm.selectCustomerDateOfBirthDay("6");
		createAccountForm.selectCustomerDateOfBirthMonth("3");
		createAccountForm.selectCustomerDateOfBirthYear("1985");	
		createAccountForm.setPostalCodeInput("12345");
		createAccountForm.setHomePhoneInput("55");
		createAccountForm.setMobilePhoneInput("51999887720");
		createAccountForm.setAddressInput("Rua");
		createAccountForm.setCityInput("Santa Cecilia");
		createAccountForm.selectState("7");
		createAccountForm.setPostalCodeInput("12345");
		createAccountForm.setHomePhoneInput("55");
		createAccountForm.setMobilePhoneInput("51999887720");
		createAccountForm.setAddressAliasInput("HOME");
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
	}
}