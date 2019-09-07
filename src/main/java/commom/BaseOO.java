package commom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.Account;
import pageObjects.Cart;
import pageObjects.CartSummary;
import pageObjects.CreateUser;
import pageObjects.CreateUserInput;
import pageObjects.Dress;
import pageObjects.Home;
import pageObjects.ShoppingActions;
import pageObjects.SignInInput;

public class BaseOO {
	protected WebDriver driver;
	
	protected Actions action;
	protected Dress dress;
	protected Cart cart;
	protected ShoppingActions shoppingActions;
	protected CartSummary summary;
	protected SignInInput signin;
	protected Account account;
	protected Home homepage;
	protected CreateUser createAccount;
	protected CreateUserInput createAccountInput;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver() {
		this.driver = new ChromeDriver();
	}
	
	public Actions getAction() {
		return action;
	}
	public void setAction(WebDriver driver) {
		this.action = new Actions(driver);
	}
	public Dress getDress() {
		return dress;
	}
	public void setDress(WebDriver driver) {
		this.dress = new Dress(driver);
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(WebDriver driver) {
		this.cart = new Cart(driver);
	}
	public ShoppingActions getShoppingActions() {
		return shoppingActions;
	}
	public void setShoppingActions(WebDriver driver) {
		this.shoppingActions = new ShoppingActions(driver);
	}
	public CartSummary getSummary() {
		return summary;
	}
	public void setSummary(WebDriver driver) {
		this.summary = new CartSummary(driver);
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(WebDriver driver) {
		this.account = new Account(driver);
	}
	public Home getHomepage() {
		return homepage;
	}
	public void setHomepage(WebDriver driver) {
		this.homepage = new Home(driver);
	}
	public CreateUser getCreateAccount() {
		return createAccount;
	}
	public void setCreateAccount(WebDriver driver) {
		this.createAccount = new CreateUser(driver);
	}
	public CreateUserInput getCreateAccountInput() {
		return createAccountInput;
	}
	public void setCreateAccountForm(WebDriver driver) {
		this.createAccountInput = new CreateUserInput(driver);
	}
	public SignInInput getSignin() {
		return signin;
	}
	public void setSignin(WebDriver driver) {
		this.signin = new SignInInput(driver);
	}
	

	
}
