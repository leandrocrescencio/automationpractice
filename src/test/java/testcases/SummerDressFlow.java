package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import utils.PropertiesUtils;

public class SummerDressFlow extends BaseTest {

	@Test(priority = 1, description="Select Dress")
	public void selectDress() {
		Assert.assertTrue(dress.getDressesBtn().isDisplayed());
		action.moveToElement(dress.getDressesBtn()).perform();
		Assert.assertTrue(dress.getSummerDressesBtn().isDisplayed());
		Assert.assertTrue(dress.getCasualDressesBtn().isDisplayed());
		Assert.assertTrue(dress.getEveningDressesBtn().isDisplayed());
		action.moveToElement(dress.getSummerDressesBtn()).perform();
		dress.getSummerDressesBtn().click();
		Assert.assertTrue(dress.getDress(1).isDisplayed());
		Assert.assertTrue(dress.getDress(2).isDisplayed());
		Assert.assertTrue(dress.getDress(3).isDisplayed());
		Assert.assertEquals(dress.getDressesCount().size(), 3);
		action.moveToElement(dress.getDress(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
		Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());
		action.click(shoppingActions.getAddToCartBtn()).build().perform();
		action.click(shoppingActions.getProceedToCheckoutBtn()).build().perform();
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

		action.moveToElement(summary.getCartProceedBtn()).perform();
		summary.getCartProceedBtn().click();

		Assert.assertTrue(signinForm.getSignInForm().isDisplayed());

		signinForm.setEmailField(PropertiesUtils.getValue("email"));
		signinForm.setPasswordField(PropertiesUtils.getValue("pass"));
		signinForm.getSignInBtn().click();
	}

	@Test(priority = 5, description="Billing Details.", dependsOnMethods={"signinRequest"} )
	public void billingAndDeliveryAddress() {
		Assert.assertEquals(summary.getCartSummBillingAdressName().getText(), "John Doe");
		Assert.assertEquals(summary.getCartSummBillingAdressOne().getText(), "Centar");
		Assert.assertEquals(summary.getCartSummBillingAdressCityState().getText(), "Novi Sad, Connecticut 21000");
		Assert.assertEquals(summary.getCartSummBillingAdressCountry().getText(), "United States");
		Assert.assertEquals(summary.getCartSummBillingAdressHomePhone().getText(), "056");
		Assert.assertEquals(summary.getCartSummBillingAdressMobile().getText(), "066");
	}

	@Test(priority = 6, description="Terms of Service.", dependsOnMethods={"billingAndDeliveryAddress"} )
	public void termsOfServiceModal() {
		summary.getCartProceedBtnTwo().click();
		summary.getCartProceedBtnTwo().click();

		action.moveToElement(summary.getCartSummTermsOfServiceDialog()).perform();
		Assert.assertTrue(summary.getCartSummTermsOfServiceDialog().isDisplayed());
		action.moveToElement(summary.getCartSummTermsOfServiceDialogClose()).perform();
		action.click(summary.getCartSummTermsOfServiceDialogClose()).build().perform();
		driver.navigate().refresh();
		summary.getCartSummTermsOfServiceCheck().click();
		summary.getCartProceedBtnTwo().click();
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
		summary.getCartSummConfirmOrderBtn().click();

		Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");
	}

	@Test(priority = 9, description="Check Order History", dependsOnMethods={"confirmOrder"} )
	public void checkIsOrderVisibleInOrderHistorySection() {
		boolean checkedItems = false;
		account.getAccountBtn().click();
		Assert.assertTrue(account.getAccountOrderHistoryBtn().isDisplayed());
		account.getAccountOrderHistoryBtn().click();
		Assert.assertTrue(account.getAccountOrderListTable().isDisplayed());
		account.getAccountBtn().click();
		account.getAccountOrderHistoryBtn().click();
		if (account.getAccountOrdersLis().size()>=1) {
			checkedItems = true;
		}
		Assert.assertEquals(checkedItems, true);
	}

}