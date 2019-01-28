package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commom.BaseTest;
import pageobjects.SignInForm;
import utils.EmailGenerator;

public class TestD extends BaseTest {

	@Test(priority = 1)
	public void selectChlotes() {
		Assert.assertTrue(dress.getDressesButton().isDisplayed());

		action.moveToElement(dress.getDressesButton()).perform();

		Assert.assertTrue(dress.getSummerDressesButton().isDisplayed());
		Assert.assertTrue(dress.getCasualDressesButton().isDisplayed());
		Assert.assertTrue(dress.getEveningDressesButton().isDisplayed());

		action.moveToElement(dress.getSummerDressesButton()).perform();
		dress.getSummerDressesButton().click();

		//Assert.assertTrue(dress.getSummerDressProduct(1).isDisplayed());
		//Assert.assertTrue(dress.getSummerDressProduct(2).isDisplayed());
		//Assert.assertTrue(dress.getSummerDressProduct(3).isDisplayed());
		Assert.assertEquals(dress.getDressesCount().size(), 3);

		//action.moveToElement(dress.getSummerDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartButton()).perform();

		Assert.assertTrue(shoppingActions.getAddToCartButton().isDisplayed());

		action.click(shoppingActions.getAddToCartButton()).build().perform();
		action.click(shoppingActions.getContinueShopingButton()).build().perform();

		Assert.assertTrue(shoppingActions.getContinueShopingButton().isDisplayed());

		action.moveToElement(cart.getCartTab()).perform();

		Assert.assertEquals(cart.getCartProductsQty().size(), 1);

		// 2. dress
		action.moveToElement(dress.getDressesButton()).perform();

		Assert.assertTrue(dress.getCasualDressesButton().isDisplayed());

		action.moveToElement(dress.getCasualDressesButton()).perform();
		dress.getCasualDressesButton().click();
		//action.moveToElement(dress.getCasualDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartButton()).perform();
		action.click(shoppingActions.getAddToCartButton()).build().perform();

		Assert.assertTrue(shoppingActions.getAddToCartButton().isDisplayed());

		action.click(shoppingActions.getContinueShopingButton()).build().perform();
		action.moveToElement(cart.getCartTab()).perform();

		Assert.assertEquals(cart.getCartProductsQty().size(), 2);

		// 3. dress
		action.moveToElement(dress.getDressesButton()).perform();

		Assert.assertTrue(dress.getEveningDressesButton().isDisplayed());

		action.moveToElement(dress.getEveningDressesButton()).perform();
		dress.getEveningDressesButton().click();
		//action.moveToElement(dress.getEveningDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartButton()).perform();
		action.click(shoppingActions.getAddToCartButton()).build().perform();

		Assert.assertTrue(shoppingActions.getAddToCartButton().isDisplayed());

		action.click(shoppingActions.getContinueShopingButton()).build().perform();
		action.moveToElement(cart.getCartTab()).perform();

		Assert.assertEquals(cart.getCartProductsQty().size(), 3);
	}

	@Test(priority = 3)
	public void deleteCartProducts() {
		Assert.assertEquals(cart.getCartProductsQty().size(), 3);

		action.moveToElement(cart.getCartTab()).perform();
		//action.moveToElement(cart.getCartProductDeleteX(2)).perform();
		//action.click(cart.getCartProductDeleteX(2)).build().perform();
		action.moveToElement(dress.getDressesButton()).perform();
		action.moveToElement(dress.getEveningDressesButton()).perform();
		dress.getEveningDressesButton().click();
		action.moveToElement(cart.getCartTab()).perform();

		Assert.assertEquals(cart.getCartProductsQty().size(), 2);
	}

	@Test(priority = 4)
	public void checkingCartProductsQtyAndPrice() {
		Assert.assertEquals(cart.getCartProductsQty().size(), 2);

		action.moveToElement(dress.getDressesButton()).perform();
		action.moveToElement(dress.getEveningDressesButton()).perform();
		//action.moveToElement(dress.getEveningDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartButton()).perform();
		action.click(shoppingActions.getAddToCartButton()).build().perform();
		action.click(shoppingActions.getContinueShopingButton()).build().perform();

		action.moveToElement(cart.getCartTab()).perform();
		action.moveToElement(cart.getCartProductsQty(1)).perform();

		Assert.assertEquals(cart.getCartProductsQty(1).getText(), "1");

		action.moveToElement(cart.getCartProductsQty(2)).perform();

		Assert.assertEquals(cart.getCartProductsQty(2).getText(), "2");

		action.moveToElement(cart.getCartShipingCost()).perform();

		Assert.assertEquals(cart.getCartShipingCost().getText(), "$2.00");

		action.moveToElement(cart.getCartTotalPrice()).perform();

		Assert.assertEquals(cart.getCartTotalPrice().getText(), "$132.96");
	}

	@Test(priority = 5)
	public void continueToShoppingSummary() {
		action.moveToElement(cart.getCartTab()).perform();
		action.moveToElement(cart.getCartTabCheckOutButton()).perform();

		Assert.assertTrue(cart.getCartTabCheckOutButton().isDisplayed());

		action.click(cart.getCartTabCheckOutButton()).build().perform();
		;

		Assert.assertTrue(summary.getCartSummaryTable().isDisplayed());
		Assert.assertEquals(summary.getCartSummTotalProductsNum().size(), 2);
		Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$130.96");
		Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$132.96");
		Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");
		Assert.assertTrue(summary.getCartSummQtyPlus(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyPlus(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyMinus(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyMinus(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyInput(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyInput(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyPlus(2).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyPlus(2).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyMinus(2).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyMinus(2).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyInput(2).isDisplayed());
		Assert.assertTrue(summary.getCartSummQtyInput(2).isDisplayed());
		Assert.assertTrue(summary.getCartSummDeleteButton(1).isDisplayed());
		Assert.assertTrue(summary.getCartSummDeleteButton(2).isDisplayed());
	}

	@Test(priority = 6)
	public void increaseQtyOfProduct1() {
		Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$130.96");
		Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$132.96");
		Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");

		summary.getCartSummQtyPlus(1).click();
		driver.navigate().refresh();

		Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$159.94");
		Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$161.94");
		Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");
	}

	@Test(priority = 7)
	public void signinRequest() {
		summary.getCartProceedButton().click();

		Assert.assertTrue(SignInForm.getSignInForm().isDisplayed());

		//SignInForm.setEmailField(EmailGenerator.getCurrentEmail());
		//SignInForm.setPasswordField("tester123");
		SignInForm.getSignInBtn().click();
	}

	@Test(priority = 8)
	public void billingAndDeliveryAddress() {
		Assert.assertEquals(summary.getCartSummBillingAdressName().getText(), "John Doe");
		Assert.assertEquals(summary.getCartSummBillingAdressOne().getText(), "Centar");
		Assert.assertEquals(summary.getCartSummBillingAdressCityState().getText(), "Novi Sad, Connecticut 21000");
		Assert.assertEquals(summary.getCartSummBillingAdressCountry().getText(), "United States");
		Assert.assertEquals(summary.getCartSummBillingAdressHomePhone().getText(), "056");
		Assert.assertEquals(summary.getCartSummBillingAdressMobile().getText(), "066");
	}

	@Test(priority = 9)
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

	@Test(priority = 10)
	public void payment() {
		summary.getCartSummPayByBankWire().click();

		Assert.assertEquals(summary.getCartSummPayByBankWireConfirm().getText(), "BANK-WIRE PAYMENT.");

		summary.getCartSummOtherPaymentMethods().click();
		summary.getCartSummPayByCheck().click();

		Assert.assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");
	}

	@Test(priority = 11)
	public void confirmOrder() {
		summary.getCartSummConfirmOrderButton().click();

		Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");
	}

	@Test(priority = 12)
	public void checkIsOrderVisibleInOrderHistorySection() {
		account.getAccountButton().click();

		Assert.assertTrue(account.getAccountOrderHistoryButton().isDisplayed());

		account.getAccountOrderHistoryButton().click();

		Assert.assertTrue(account.getAccountOrderListTable().isDisplayed());

		account.getAccountButton().click();
		account.getAccountOrderHistoryButton().click();

		Assert.assertEquals(account.getAccountOrdersLis().size(), 1);
	}
}