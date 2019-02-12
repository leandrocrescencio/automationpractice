package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class SummerDressFlowTest extends BaseTest {

	@Test(priority = 1, description="Select Dress")
	public void selectDress() {
		Assert.assertTrue(dress.getDressesButton().isDisplayed());
		action.moveToElement(dress.getDressesButton()).perform();
		Assert.assertTrue(dress.getSummerDressesButton().isDisplayed());
		Assert.assertTrue(dress.getCasualDressesButton().isDisplayed());
		Assert.assertTrue(dress.getEveningDressesButton().isDisplayed());
		action.moveToElement(dress.getSummerDressesButton()).perform();
		dress.getSummerDressesButton().click();
		Assert.assertTrue(dress.getDress(1).isDisplayed());
		Assert.assertTrue(dress.getDress(2).isDisplayed());
		Assert.assertTrue(dress.getDress(3).isDisplayed());
		Assert.assertEquals(dress.getDressesCount().size(), 3);
		action.moveToElement(dress.getDress(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartButton()).perform();
		Assert.assertTrue(shoppingActions.getAddToCartButton().isDisplayed());
		action.click(shoppingActions.getAddToCartButton()).build().perform();
		action.click(shoppingActions.getProceedToCheckoutButton()).build().perform();
		action.moveToElement(cart.getCartTab()).perform();
		Assert.assertEquals(cart.getCartTotalProductsQty().size(), 1);
	}

	@Test(priority = 2, description="Check Summary.", dependsOnMethods={"selectDress"} )
	public void checkSummary() {
		action.moveToElement(summary.getCartSummaryTable()).perform();

		Assert.assertTrue(summary.getCartSummaryTable().isDisplayed());
		Assert.assertEquals(summary.getCartSummTotalProductsNum().size(), 1);
		Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$28.98");
		Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$30.98");
		Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");
		Assert.assertTrue(summary.getCartSummQtyPlus(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyMinus(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyInput(1).isDisplayed());
		
		action.moveToElement(summary.getCartProceedButton()).perform();
		summary.getCartProceedButton().click();

	}

	@Test(priority = 3, description="Create New User Account" , dependsOnMethods={"checkSummary"} )
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

		
		action.moveToElement(summary.getCartSummaryTable()).perform();
		action.moveToElement(summary.getCartProceedButton()).perform();
		summary.getCartProceedButton().click();
		
	}
	
	@Test(priority = 4, description="Billing Details.", dependsOnMethods={"createNewUser"} )
	public void billingAndDeliveryAddress() {
		Assert.assertEquals(summary.getCartSummBillingAdressName().getText(), PropertiesUtils.getValue("firstname").concat(" ").concat(PropertiesUtils.getValue("lastname")));
		Assert.assertEquals(summary.getCartSummBillingAdressHomePhone().getText(), "55");
		Assert.assertEquals(summary.getCartSummBillingAdressMobile().getText(), "51999887720");
	}

	@Test(priority = 5, description="Terms of Service.", dependsOnMethods={"billingAndDeliveryAddress"} )
	public void termsOfServiceModal() {
		summary.getCartProceedButton2().click();
		summary.getCartProceedButton2().click();

		action.moveToElement(summary.getCartSummTermsOfServiceDialog()).perform();
		Assert.assertTrue(summary.getCartSummTermsOfServiceDialog().isDisplayed());
		action.moveToElement(summary.getCartSummTermsOfServiceDialogClose()).perform();
		action.click(summary.getCartSummTermsOfServiceDialogClose()).build().perform();
		driver.navigate().refresh();
		summary.getCartSummTermsOfServiceCheck().click();
		summary.getCartProceedButton2().click();
	}

	@Test(priority = 6, description="Payment", dependsOnMethods={"termsOfServiceModal"} )
	public void payment() {
		summary.getCartSummPayByBankWire().click();

		Assert.assertEquals(summary.getCartSummPayByBankWireConfirm().getText(), "BANK-WIRE PAYMENT.");

		summary.getCartSummOtherPaymentMethods().click();
		summary.getCartSummPayByCheck().click();

		Assert.assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");
	}

	@Test(priority = 7, description="Confirm Order", dependsOnMethods={"payment"} )
	public void confirmOrder() {
		summary.getCartSummConfirmOrderButton().click();

		Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");
	}

	@Test(priority = 8, description="Check Order History", dependsOnMethods={"confirmOrder"} )
	public void checkIsOrderVisibleInOrderHistorySection() {
		boolean checkedItems = false;
		account.getAccountButton().click();
		Assert.assertTrue(account.getAccountOrderHistoryButton().isDisplayed());
		account.getAccountOrderHistoryButton().click();
		Assert.assertTrue(account.getAccountOrderListTable().isDisplayed());
		account.getAccountButton().click();
		account.getAccountOrderHistoryButton().click();
		if (account.getAccountOrdersLis().size()>=1) {
			checkedItems = true;
		}
		Assert.assertEquals(checkedItems, true);
	}

}