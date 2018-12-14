package pageobjects;

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
		return WebUtils.elementWait(driver, By.id("cart_summary"), 30);
	}
	
	public WebElement getCartSummUnitPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price special-price\"]"), 30);
	}
	
	public WebElement getCartSummSpecialUnitPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price\"]/span[@class=\"price special-price\"]"), 30);
	}
	
	public WebElement getCartSummQtyInput(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//input[@type=\"text\"]"), 30);
	}
	
	public void setCartSummQtyInput(int numOfProduct, String qty) {
		WebElement customerFirstNameField = this.getCartSummQtyInput(numOfProduct);
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(qty);
	}
	
	public WebElement getCartSummQtyMinus(int numOfProduct) {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Subtract\"]"), 30);
	}
	
	public WebElement getCartSummQtyPlus(int numOfProduct) {
		return WebUtils.clickWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Add\"]"), 30);
	}
	
	public WebElement getCartSummTotalPrice(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Total\"]/span[@class=\"price\"]"), 30);
	}
	
	public WebElement getCartSummDeleteBtn(int numOfProduct) {
		return WebUtils.elementWait(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Delete\"]"), 30);
	}
	
	public WebElement getCartSummTotalProductsPrice() {
		return WebUtils.elementWait(driver, By.id("total_product"), 30);
	}
	
	public WebElement getCartSummTotalShipping() {
		return WebUtils.elementWait(driver, By.id("total_shipping"), 30);
	}
	
	public WebElement getCartSummWithoutTax() {
		return WebUtils.elementWait(driver, By.id("total_price_without_tax"), 30);
	}
	
	public WebElement getCartSummaryTotalPrice() {
		return WebUtils.elementWait(driver, By.id("total_price"), 30);
	}
	
	public WebElement getCartEmptyMessage() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Your shopping cart is empty.\")]"), 30);
	}
	
	public WebElement getCartProceedBtn() {
		return WebUtils.clickWait(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"), 30);
	}
	
	public WebElement getCartProceedPreviousBtn() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Previous\"]"), 30);
	}
	
	public WebElement getCartProceedBtnTwo() {
		return WebUtils.clickWait(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"), 30);
	}
	
	public WebElement getCartSummBillingAdressName() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressCompany() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_company\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressOne() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_address1 address_address2\"]"), 30);
	}	
	
	public WebElement getCartSummBillingAdressCityState() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_city address_state_name address_postcode\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressCountry() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_country_name\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressHomePhone() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone\"]"), 30);
	}
	
	public WebElement getCartSummBillingAdressMobile() {
		return WebUtils.elementWait(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone_mobile\"]"), 30);
	}
	
	public WebElement getCartSummTermsOfServiceCheck() {
		return WebUtils.elementWait(driver, By.id("cgv"), 30);
	}
	
	public WebElement getCartSummTermsOfServiceDialog() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"You must agree to the terms of service before continuing.\")]"), 30);
	}
	
	public WebElement getCartSummTermsOfServiceDialogClose() {
		return WebUtils.elementWait(driver, By.xpath("//a[@class=\"fancybox-item fancybox-close\"]"), 30);
	}
	
	public WebElement getCartSummPayByBankWire() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"), 30);
	}
	
	public WebElement getCartSummPayByCheck() {
		return WebUtils.clickWait(driver, By.xpath("//a[@title=\"Pay by check.\"]"), 30);
	}
	
	public WebElement getCartSummPayByBankWireConfirm() {
		return WebUtils.elementWait(driver, By.xpath("//h3[contains(text(), \"Bank-wire payment.\")]"), 30);
	}
	
	public WebElement getCartSummPayByCheckConfirm() {
		return WebUtils.elementWait(driver, By.xpath("//h3[contains(text(), \"Check payment\")]"), 30);
	}
	
	public WebElement getCartSummConfirmOrderBtn() {
		return WebUtils.clickWait(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"), 30);
	}
	
	public WebElement getCartSummOtherPaymentMethods() {
		return WebUtils.clickWait(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"), 30);
	}
	
	public WebElement getCartSummSuccessMsg() {
		return WebUtils.elementWait(driver, By.xpath("//p[contains(text(), \"Your order on My Store is complete.\")]"), 30);
	}
	
	public List<WebElement> getCartSummTotalProductsNum() {
		return driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
	}
}