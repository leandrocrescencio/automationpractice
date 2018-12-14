package commom;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.LogStatus;

import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.PropertiesUtils;
import utils.StaticValues;

public class BaseTest extends BaseOO {
	
	protected static final Log LOG = LogFactory.getLog(BaseTest.class);
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", PropertiesUtils.getValue("driver"));
		setDriver();
		driver = getDriver();
		
		init(driver);
		action = getAction();
		dress = getDress();
		cart = getCart();
		shoppingActions = getShoppingActions();
		summary = getSummary();
		account = getAccount();
		homepage = getHomepage();
		createAccount = getCreateAccount();
		createAccountInput = getCreateAccountInput();
		signin = getSignin();
		account = getAccount();

		driver.manage().window().maximize();
		driver.get(PropertiesUtils.getValue("url"));
	}
	
	public void init(WebDriver driver) {
		setAction(driver);
		setDress(driver);
		setCart(driver);
		setShoppingActions(driver);
		setSummary(driver);
		setHomepage(driver);
		setSignin(driver);
		setCreateAccountForm(driver);
		setCreateAccount(driver);
		setAccount(driver);
		StaticValues.setCLASS("teste");
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
	        if (StaticValues.getCLASS().equalsIgnoreCase("teste")) {
	            setName(this.getClass().getSimpleName());
	        }
	        ExtentTestManager.startTest(method.getName(),StaticValues.getCLASS());
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
	        ExtentManager.getReporter(StaticValues.getCLASS()).endTest(ExtentTestManager.getTest());
	        ExtentManager.getReporter(StaticValues.getCLASS()).flush();

	    }

	    public static void setName(String ct) {
	        StaticValues.setCLASS(ct);
	    }


	    protected String getStackTrace(Throwable t) {
	        StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);
	        t.printStackTrace(pw);
	        return sw.toString();
	    }

}
