package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class SummerDressFlow extends BaseTest {

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
		Assert.assertEquals(cart.getCartProductsQty().size(), 1);
	}

	@Test(priority = 2, description="Check Cart.", dependsOnMethods={"selectDress"} )
	public void checkingCartProductsQtyAndPrice() {
		action.moveToElement(cart.getCartTab()).perform();
		action.moveToElement(cart.getCartProductsQty(1)).perform();
		Assert.assertEquals(cart.getCartProductsQty(1).getText(), "1");
		action.moveToElement(cart.getCartShipingCost()).perform();
		Assert.assertEquals(cart.getCartShipingCost().getText(), "$2.00");
		action.moveToElement(cart.getCartTotalPrice()).perform();
		Assert.assertEquals(cart.getCartTotalPrice().getText(), "$30.98");
	}

	@Test(priority = 3, description="Check Summary.", dependsOnMethods={"checkingCartProductsQtyAndPrice"} )
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
	}

	@Test(priority = 4, description="Sign In.", dependsOnMethods={"checkSummary"} )
	public void signinRequest() {

		action.moveToElement(summary.getCartProceedButton()).perform();
		summary.getCartProceedButton().click();

		Assert.assertTrue(signin.getSignInInput().isDisplayed());

		signin.setEmailInput(PropertiesUtils.getValue("email"));
		signin.setPasswordInput(PropertiesUtils.getValue("pass"));
		signin.getSignInButton().click();
	}

	@Test(priority = 5, description="Billing Details.", dependsOnMethods={"signinRequest"} )
	public void billingAndDeliveryAddress() {
		Assert.assertEquals(summary.getCartSummBillingAdressName().getText(), PropertiesUtils.getValue("firstname").concat(" ").concat(PropertiesUtils.getValue("lastname")));
		Assert.assertEquals(summary.getCartSummBillingAdressHomePhone().getText(), "55");
		Assert.assertEquals(summary.getCartSummBillingAdressMobile().getText(), "51999887720");
	}

	@Test(priority = 6, description="Terms of Service.", dependsOnMethods={"billingAndDeliveryAddress"} )
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

	@Test(priority = 7, description="Payment", dependsOnMethods={"termsOfServiceModal"} )
	public void payment() {
		summary.getCartSummPayByBankWire().click();

		Assert.assertEquals(summary.getCartSummPayByBankWireConfirm().getText(), "BANK-WIRE PAYMENT.");

		summary.getCartSummOtherPaymentMethods().click();
		summary.getCartSummPayByCheck().click();

		Assert.assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");
	}

	@Test(priority = 8, description="Confirm Order", dependsOnMethods={"payment"} )
	public void confirmOrder() {
		summary.getCartSummConfirmOrderButton().click();

		Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");
	}

	@Test(priority = 9, description="Check Order History", dependsOnMethods={"confirmOrder"} )
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