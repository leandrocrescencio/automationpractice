package commom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.Account;
import pageObjects.Cart;
import pageObjects.CartSummary;
import pageObjects.Clothes;
import pageObjects.CreateAccount;
import pageObjects.CreateAccountForm;
import pageObjects.Homepage;
import pageObjects.ShoppingActions;
import pageObjects.SignInForm;

public class BaseTest {
	
	public WebDriver driver;
	public Actions action;
	
	public Clothes clothes;
	public Cart cart;
	public ShoppingActions shoppingActions;
	public CartSummary summary;
	public SignInForm signinForm;
	public Account account;
	public Homepage homepage;
	public CreateAccount createAccount;
	public CreateAccountForm createAccountForm;
	public SignInForm signin;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();

		action = new Actions(driver);

		clothes = new Clothes(driver);
		cart = new Cart(driver);
		shoppingActions = new ShoppingActions(driver);
		signinForm = new SignInForm(driver);
		summary = new CartSummary(driver);
		account = new Account(driver);
		
		homepage = new Homepage(driver);
		createAccount = new CreateAccount(driver);
		createAccountForm = new CreateAccountForm(driver);
		signin = new SignInForm(driver);
		account = new Account(driver);

		
		
		String baseUrl = "http://automationpractice.com/index.php";
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() {
		//account.getAccountLogout().click();
		//driver.quit();
	}

}
