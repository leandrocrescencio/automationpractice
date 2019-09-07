package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commom.WebUtils;

public class CartSummary {
	
	private WebDriver driver;
	
	public CartSummary(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartSummaryTable() {
		return WebUtils.elementWait(driver, By.id("cart_summary"));
	}
	
	public WebElement getCartSummUnitPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price special-price\"]"));
	}
	
	public WebElement getCartSummSpecialUnitPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price\"]/span[@class=\"price special-price\"]"));
	}
	
	public WebElement getCartSummQtyInput(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//input[@type=\"text\"]"));
	}
	
	public void setCartSummQtyInput(int numOfProduct, String qty) {
		WebElement customerFirstNameField = this.getCartSummQtyInput(numOfProduct);
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(qty);
	}
	
	public WebElement getCartSummQtyMinus(int numOfProduct) {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Subtract\"]"));
	}
	
	public WebElement getCartSummQtyPlus(int numOfProduct) {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Add\"]"));
	}
	
	public WebElement getCartSummTotalPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Total\"]/span[@class=\"price\"]"));
	}
	
	public WebElement getCartSummDeleteButton(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Delete\"]"));
	}
	
	public WebElement getCartSummTotalProductsPrice() {
		return WebUtils.elementWait(driver, By.id("total_product"));
	}
	
	public WebElement getCartSummTotalShipping() {
		return WebUtils.elementWait(driver, By.id("total_shipping"));
	}
	
	public WebElement getCartSummWithoutTax() {
		return WebUtils.elementWait(driver, By.id("total_price_without_tax"));
	}
	
	public WebElement getCartSummaryTotalPrice() {
		return WebUtils.elementWait(driver, By.id("total_price"));
	}
	
	public WebElement getCartEmptyMessage() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Your shopping cart is empty.\")]"));
	}
	
	public WebElement getCartProceedButton() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
	}
	
	public WebElement getCartProceedPreviousButton() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Previous\"]"));
	}
	
	public WebElement getCartProceedButton2() {
		return WebUtils.clickWait(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"));
	}
	
	public WebElement getCartSummBillingAdressName() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]"));
	}
	
	public WebElement getCartSummBillingAdressCompany() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_company\"]"));
	}
	
	public WebElement getCartSummBillingAdressOne() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_address1 address_address2\"]"));
	}	
	
	public WebElement getCartSummBillingAdressCityState() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_city address_state_name address_postcode\"]"));
	}
	
	public WebElement getCartSummBillingAdressCountry() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_country_name\"]"));
	}
	
	public WebElement getCartSummBillingAdressHomePhone() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone\"]"));
	}
	
	public WebElement getCartSummBillingAdressMobile() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone_mobile\"]"));
	}
	
	public WebElement getCartSummTermsOfServiceCheck() {
		return WebUtils.elementWait(driver, By.id("cgv"));
	}
	
	public WebElement getCartSummTermsOfServiceDialog() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"You must agree to the terms of service before continuing.\")]"));
	}
	
	public WebElement getCartSummTermsOfServiceDialogClose() {
		return WebUtils.elementWait(driver, By.xpath("//a[@class=\"fancybox-item fancybox-close\"]"));
	}
	
	public WebElement getCartSummPayByBankWire() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"));
	}
	
	public WebElement getCartSummPayByCheck() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Pay by check.\"]"));
	}
	
	public WebElement getCartSummPayByBankWireConfirm() {
		return WebUtils.elementWait(driver, By.xpath("//h3[contains(text(), \"Bank-wire payment.\")]"));
	}
	
	public WebElement getCartSummPayByCheckConfirm() {
		return WebUtils.elementWait(driver, By.xpath("//h3[contains(text(), \"Check payment\")]"));
	}
	
	public WebElement getCartSummConfirmOrderButton() {
		return WebUtils.clickWait(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"));
	}
	
	public WebElement getCartSummOtherPaymentMethods() {
		return WebUtils.clickWait(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"));
	}
	
	public WebElement getCartSummSuccessMsg() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Your order on My Store is complete.\")]"));
	}
	
	public List<WebElement> getCartSummTotalProductsNum() {
		return driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
	}
}