package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;
import utils.StaticValues;

public class CartSummary {
	
	private WebDriver driver;
	
	public CartSummary(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartSummaryTable() {
		return WebUtils.elementWait(driver, By.id("cart_summary"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummUnitPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price special-price\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummSpecialUnitPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price\"]/span[@class=\"price special-price\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummQtyInput(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//input[@type=\"text\"]"), StaticValues.TIMEOUT);
	}
	
	public void setCartSummQtyInput(int numOfProduct, String qty) {
		WebElement customerFirstNameField = this.getCartSummQtyInput(numOfProduct);
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(qty);
	}
	
	public WebElement getCartSummQtyMinus(int numOfProduct) {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Subtract\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummQtyPlus(int numOfProduct) {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Add\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummTotalPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Total\"]/span[@class=\"price\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummDeleteButton(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Delete\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummTotalProductsPrice() {
		return WebUtils.elementWait(driver, By.id("total_product"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummTotalShipping() {
		return WebUtils.elementWait(driver, By.id("total_shipping"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummWithoutTax() {
		return WebUtils.elementWait(driver, By.id("total_price_without_tax"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummaryTotalPrice() {
		return WebUtils.elementWait(driver, By.id("total_price"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartEmptyMessage() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Your shopping cart is empty.\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartProceedButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartProceedPreviousButton() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Previous\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartProceedButton2() {
		return WebUtils.clickWait(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummBillingAdressName() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummBillingAdressCompany() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_company\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummBillingAdressOne() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_address1 address_address2\"]"), StaticValues.TIMEOUT);
	}	
	
	public WebElement getCartSummBillingAdressCityState() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_city address_state_name address_postcode\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummBillingAdressCountry() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_country_name\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummBillingAdressHomePhone() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummBillingAdressMobile() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone_mobile\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummTermsOfServiceCheck() {
		return WebUtils.elementWait(driver, By.id("cgv"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummTermsOfServiceDialog() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"You must agree to the terms of service before continuing.\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummTermsOfServiceDialogClose() {
		return WebUtils.elementWait(driver, By.xpath("//a[@class=\"fancybox-item fancybox-close\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummPayByBankWire() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummPayByCheck() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Pay by check.\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummPayByBankWireConfirm() {
		return WebUtils.elementWait(driver, By.xpath("//h3[contains(text(), \"Bank-wire payment.\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummPayByCheckConfirm() {
		return WebUtils.elementWait(driver, By.xpath("//h3[contains(text(), \"Check payment\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummConfirmOrderButton() {
		return WebUtils.clickWait(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummOtherPaymentMethods() {
		return WebUtils.clickWait(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"), StaticValues.TIMEOUT);
	}
	
	public WebElement getCartSummSuccessMsg() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Your order on My Store is complete.\")]"), StaticValues.TIMEOUT);
	}
	
	public List<WebElement> getCartSummTotalProductsNum() {
		return driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
	}
}