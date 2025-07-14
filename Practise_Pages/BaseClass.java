package Practise_Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReport;

public class BaseClass {

	//public static WebDriver driver;
	public  WebDriver driver;
	public Properties prop;
	public ExtentReports report= ExtentReport.getInstance();
	public ExtentTest logger;

	SoftAssert sftassert= new SoftAssert();
 
	public void invokeBrowser(String browsername) throws IOException, InterruptedException {
		try{
			
		  
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.chrome.driver", "D:/Driver/chromedriver_stable.exe");    
			driver = new ChromeDriver();  
		} }catch(Exception e) {   
			reportFail(e.getMessage());
			System.out.println("Undefined Browser");   
		}
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//driver.manage().timeouts().wait(1000); 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		//driver.manage().timeouts().getPageLoadTimeout();

		if (prop == null) {
			System.out.println(System.getProperty("user.dir") + "destination");
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "//src/main/java/Practise_Pages/Config_Prop.Properties");
				prop.load(file);
			} catch (FileNotFoundException e) {
				reportFail(e.getMessage());
				e.printStackTrace();
			}

		}

	}

	public void OpenURL(String websitename) {
		try{
			driver.get(prop.getProperty(websitename));

		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		// driver.get(websiteurl);
	}
	
	public Amazon_Add_Cart clickin()
	{
		return PageFactory.initElements(driver, Amazon_Add_Cart.class);
	}

	public void tearDown() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

/***********************************Assertion***************************************************/	
	public void assertTrue(boolean flag)
	{
		sftassert.assertTrue(flag);
	}
	
	public void assertFalse(boolean flag)
	{
		sftassert.assertFalse(flag);
	}
	
	public void assertEquals(String actual, String expected)
	{
		sftassert.assertEquals(actual, expected);
	}
			
/************************Element Locator********************************************************/
	public void enterText(String xpathkey, String data) {
		// driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(data);
		try{
			getElement(xpathkey).sendKeys(data);
			logger.log(Status.INFO, "Entering text:"+data);
		}catch(Exception e)
		{
			reportFail(e.getMessage());
			logger.log(Status.FAIL, "Path not found:"+xpathkey);


		}
	}

	public void elementClick(String xpathkey) {
		try{
			getElement(xpathkey).click();
			logger.log(Status.INFO, "Clicking on element"+xpathkey);
		}catch(Exception e)
		{
			reportFail(e.getMessage());
			logger.log(Status.FAIL, "Path not found:"+xpathkey);


		}

	}

	public boolean isElementDisplayed(String locatorkey)
	{
		try{
			if(getElement(locatorkey).isDisplayed())
			{
				return true;

			}
			
		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		return false;

		
		
	}
	
	public boolean isElementSelected(String locatorkey)
	{
		try{
			if(getElement(locatorkey).isSelected())
			{
				return true;
			}
		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
		return false;
		
	}
	
	public boolean isElementEnabled(String locatorkey)
	{
		try{
			if(getElement(locatorkey).isEnabled())
			{
				return true;
			}
		}catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
		return false;
		
	}
	
	public boolean compareString(String itemsneeded, String sentence)
	{
		if(sentence.indexOf(itemsneeded)>0)
		{
			return true;
		}
		
		return false;
		
	}
	
	public WebElement getElement(String locatorkey) {
		WebElement element = null;
		
		try{
		if (locatorkey.endsWith("_Id")) { 
			element = driver.findElement(By.id(prop.getProperty(locatorkey)));
			logger.log(Status.INFO, "Locator identified"+locatorkey);
		} else if (locatorkey.endsWith("_Xpath")) {
			element = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			logger.log(Status.INFO, "Locator identified"+locatorkey);

		} else if (locatorkey.endsWith("_CSS")) {
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorkey)));
			logger.log(Status.INFO, "Locator identified"+locatorkey);
		} else if (locatorkey.endsWith("_Name")) {
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorkey)));
			logger.log(Status.INFO, "Locator identified"+locatorkey);
		}
		else if(locatorkey.endsWith("_Link"))
		{
			element=driver.findElement(By.linkText(locatorkey));
			logger.log(Status.INFO, "Locator identified"+locatorkey);
			
		}
		else{
			reportFail("Failing Testcase, Invalid Locator"+locatorkey);
			Assert.fail("Failing Testcase, Invalid Locator"+locatorkey);
		}
		}
		
		catch(Exception e)
		{
			reportFail(e.getMessage());
			e.printStackTrace();
			Assert.fail("Failing Testcase"+e.getMessage());
		}
		return element;
	}
	
	
public List<WebElement> getElements(String locatorkey)
{
	List<WebElement> element=null;
	try{
		if (locatorkey.endsWith("_Xpath")) { 
			element = driver.findElements(By.xpath(prop.getProperty(locatorkey)));
			logger.log(Status.INFO, "Locator identified"+locatorkey);
		}
	}catch(Exception e)
	{
		reportFail(e.getMessage());
		e.printStackTrace();
		Assert.fail("Failing Testcases"+e.getMessage());
	}
	
	return element;
}

/***********************Reporting******************************/	
	public void reportFail(String reportString)
	{
		logger.log(Status.FAIL, reportString);
		Assert.fail(reportString);
	}
	
	public void reportPass(String reportString)
	{
		logger.log(Status.PASS, reportString);
	}
	
/************* *******Screenshot *************************************/
	public String ScreenshotOnFailure(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty(("user.dir")+"//reports//"+testCaseName+".png"));
		FileUtils.copyFile(source, file);
		return testCaseName;
		
	}
/************************Waits************************************************/
public void WaitForElement(String locatorkey)
{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locatorkey)));
}

public void WaitForElementtoDisappear(String locatorkey) throws InterruptedException
{
	getElement(locatorkey);
	Thread.sleep(1000);
}

public void WaitForElementtoClick(String locatorkey)
{
	try{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locatorkey)));
	}catch(Exception e)
	{
		reportFail(e.getMessage());
		System.out.println("failed to wait");
	}
	
	//getElement(locatorkey).click();
}
	
}


