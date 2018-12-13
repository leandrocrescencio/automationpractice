package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class CreateNewAccount extends BaseTest {

	@Test(priority = 1, description="Create New User Account")
	public void createNewUser() {
		homepage.getSignInBtn().click();

		Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(createAccount.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(signin.getSignInForm().isDisplayed());
		createAccount.setCreateAccountEmailField(PropertiesUtils.getValue("email"));
		createAccount.getCreateAccountBtn().click();
		Assert.assertTrue(createAccountForm.getAccountCreationForm().isDisplayed());
	
		createAccountForm.setCustomerFirstNameField("Juarez");
		createAccountForm.setCustomerLastNameField("Roth");
		createAccountForm.setCustomerEmailField(PropertiesUtils.getValue("email"));
		createAccountForm.setCustomerPasswordField(PropertiesUtils.getValue("pass"));
		createAccountForm.getAccountCreationForm().click();		
		Assert.assertTrue(createAccountForm.getFirstNameHighlightedGreen().isDisplayed());
		Assert.assertTrue(createAccountForm.getLastNameHighlightedGreen().isDisplayed());
		Assert.assertTrue(createAccountForm.getEmailHighlightedGreen().isDisplayed());
		Assert.assertTrue(createAccountForm.getPasswordHighlightedGreen().isDisplayed());

		createAccountForm.selectCustomerDateOfBirthDay("6");
		createAccountForm.selectCustomerDateOfBirthMonth("3");
		createAccountForm.selectCustomerDateOfBirthYear("1985");	
		createAccountForm.setPostalCodeField("21000");
		createAccountForm.setHomePhoneField("056");
		createAccountForm.setMobilePhoneField("065");
		createAccountForm.setAddressField("Rua");
		createAccountForm.setCityField("Santa Cecilia");
		createAccountForm.selectState("7");
		createAccountForm.setPostalCodeField("12345");
		createAccountForm.setHomePhoneField("055");
		createAccountForm.setMobilePhoneField("51999887720");
		createAccountForm.setAddressAliasField("HOME");
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.getEmailBeenRegistered().isDisplayed());

		createAccountForm.setCustomerEmailField(PropertiesUtils.getValue("email"));
		createAccountForm.setCustomerPasswordField(PropertiesUtils.getValue("pass"));
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
	}
}