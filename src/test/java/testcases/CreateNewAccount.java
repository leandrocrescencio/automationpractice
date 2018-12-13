package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class CreateNewAccount extends BaseTest {

	@Test(priority = 1)
	public void authenticationPage() {
		homepage.getSignInBtn().click();

		Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(createAccount.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(signin.getSignInForm().isDisplayed());
	}

	@Test(priority = 2)
	public void authenticationPageEmailField() {
		// Without email
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccount.getEmailErrorMessage().isDisplayed());

		// Wrong email format (mapko89ct, mapko89ct@gmail ...)
		createAccount.setCreateAccountEmailField("marko");
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccount.getEmailErrorMessage().isDisplayed());
		Assert.assertTrue(createAccount.getEmailFieldHighlightedRed().isDisplayed());

		// Registered email
		createAccount.setCreateAccountEmailField(PropertiesUtils.getValue("email"));
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccount.getEmailBeenRegistered().isDisplayed());

		// Correct email
		createAccount.setCreateAccountEmailField(PropertiesUtils.getValue("email"));
		createAccount.getCreateAccountBtn().click();

		Assert.assertTrue(createAccountForm.getAccountCreationForm().isDisplayed());
	}

	@Test(priority = 6)
	public void createAccountSuccessfully() {
		// Correct format
		createAccountForm.setCustomerEmailField(PropertiesUtils.getValue("mail"));
		createAccountForm.setCustomerPasswordField(PropertiesUtils.getValue("pass"));
		createAccountForm.setPostalCodeField("21000");
		createAccountForm.setHomePhoneField("056");
		createAccountForm.setMobilePhoneField("065");

		Assert.assertTrue(createAccountForm.getEmailInvalidError().isDisplayed());
		Assert.assertTrue(createAccountForm.getPasswordInvalidError().isDisplayed());
		Assert.assertTrue(createAccountForm.getPostalCodeError().isDisplayed());
		Assert.assertTrue(createAccountForm.getHomePhoneInvalidError().isDisplayed());
		Assert.assertTrue(createAccountForm.getMobilePhoneInvalidError().isDisplayed());
		// Required fields filled
		createAccountForm.setCustomerFirstNameField("John");
		createAccountForm.setCustomerLastNameField("Doe");
		createAccountForm.setCustomerPasswordField(PropertiesUtils.getValue("pass"));
		createAccountForm.selectCustomerDateOfBirthDay("20");
		createAccountForm.selectCustomerDateOfBirthMonth("10");
		createAccountForm.selectCustomerDateOfBirthYear("2000");
		createAccountForm.setAddressField("Centar");
		createAccountForm.setCityField("Novi Sad");
		createAccountForm.selectState("7");
		createAccountForm.setPostalCodeField("21000");
		createAccountForm.setHomePhoneField("056");
		createAccountForm.setMobilePhoneField("066");
		createAccountForm.setAddressAliasField("My Address");
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.getEmailBeenRegistered().isDisplayed());

		createAccountForm.setCustomerEmailField(PropertiesUtils.getValue("email"));
		createAccountForm.setCustomerPasswordField(PropertiesUtils.getValue("pass"));
		createAccountForm.getRegisterBtn().click();

		Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
	}
}