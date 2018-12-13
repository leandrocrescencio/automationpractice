package commom;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Account;
import pageObjects.Cart;
import pageObjects.CartSummary;
import pageObjects.Clothes;
import pageObjects.CreateAccount;
import pageObjects.CreateAccountForm;
import pageObjects.Homepage;
import pageObjects.ShoppingActions;
import pageObjects.SignInForm;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.PropertiesUtils;
import utils.StaticValues;

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
		System.setProperty("webdriver.chrome.driver", PropertiesUtils.getValue("driver"));
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
		account.getAccountLogout().click();
		driver.quit();
	}
	
	
	 @BeforeSuite(alwaysRun = true)
	    public void extentSetup(ITestContext context) {
	        if (!context.getName().contains("Default") && !context.getName().contains("Surefire")) {
	            setName(context.getName());
	        }
	    }

	    @BeforeMethod(alwaysRun = true)
	    public void beforeMethod(Method method) {
	        if (StaticValues.CLASS.equalsIgnoreCase("teste")) {
	            setName(this.getClass().getSimpleName());
	        }
	        ExtentTestManager.startTest(method.getName(),StaticValues.CLASS);
	        if(!ExtentTestManager.getTest().getDescription().isEmpty()) {
	            ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest().getDescription());
	        }
	    }

	    @AfterMethod(alwaysRun = true)
	    protected void afterMethod(ITestResult result) {
	        for (String group : result.getMethod().getGroups()) {
	            ExtentTestManager.getTest().assignCategory(group);  // new
	        }
	        switch (result.getStatus()) {
	            case ITestResult.FAILURE:
	                ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
	                break;
	            case ITestResult.SKIP:
	                ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped " + result.getThrowable());
	                break;
	            case ITestResult.SUCCESS:
	                ExtentTestManager.getTest().log(LogStatus.PASS, "Teste Passed");
	                break;
	            default:
	                if (ExtentTestManager.getTest().getRunStatus().equals(LogStatus.UNKNOWN)) {
	                    ExtentTestManager.getTest().log(LogStatus.SKIP, "This test method is skipped");
	                } else {
	                    ExtentTestManager.endTest();
	                }
	        }
	        ExtentManager.getReporter(StaticValues.CLASS).endTest(ExtentTestManager.getTest());
	        ExtentManager.getReporter(StaticValues.CLASS).flush();

	    }

	    public static void setName(String ct) {
	        StaticValues.CLASS = ct;
	    }


	    protected String getStackTrace(Throwable t) {
	        StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);
	        t.printStackTrace(pw);
	        return sw.toString();
	    }

}
