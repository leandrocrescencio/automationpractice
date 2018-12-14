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
		Assert.assertTrue(createAccount.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(signin.getSignInForm().isDisplayed());
		createAccount.setCreateAccountEmailField(PropertiesUtils.getValue("email"));
		createAccount.getCreateAccountBtn().click();
		Assert.assertTrue(createAccountForm.getAccountCreationInput().isDisplayed());
	
		createAccountForm.setCustomerFirstNameInput("Juarez");
		createAccountForm.setCustomerLastNameInput("Roth");
		createAccountForm.setCustomerEmailInput(PropertiesUtils.getValue("email"));
		createAccountForm.setCustomerPasswordInput(PropertiesUtils.getValue("pass"));
		createAccountForm.getAccountCreationInput().click();		
		Assert.assertTrue(createAccountForm.getFirstNameHighlightedGreen().isDisplayed());
		Assert.assertTrue(createAccountForm.getLastNameHighlightedGreen().isDisplayed());
		Assert.assertTrue(createAccountForm.getEmailHighlightedGreen().isDisplayed());
		Assert.assertTrue(createAccountForm.getPasswordHighlightedGreen().isDisplayed());

		createAccountForm.selectCustomerDateOfBirthDay("6");
		createAccountForm.selectCustomerDateOfBirthMonth("3");
		createAccountForm.selectCustomerDateOfBirthYear("1985");	
		createAccountForm.setPostalCodeInput("21000");
		createAccountForm.setHomePhoneInput("056");
		createAccountForm.setMobilePhoneInput("065");
		createAccountForm.setAddressInput("Rua");
		createAccountForm.setCityInput("Santa Cecilia");
		createAccountForm.selectState("7");
		createAccountForm.setPostalCodeInput("12345");
		createAccountForm.setHomePhoneInput("055");
		createAccountForm.setMobilePhoneInput("51999887720");
		createAccountForm.setAddressAliasInput("HOME");
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.getEmailBeenRegistered().isDisplayed());

		createAccountForm.setCustomerEmailInput(PropertiesUtils.getValue("email"));
		createAccountForm.setCustomerPasswordInput(PropertiesUtils.getValue("pass"));
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
	}
}