package SELENIUM.SELENIUM_PROJECT;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import Utilities.ExcelUtil;

public class BaseClass {

	public static WebDriver driver;
	
/*	public static void main(String[] args) throws InterruptedException {

	}*/
	@Test
	public static void BaseClass1() throws InterruptedException, InvalidFormatException
	{
		System.setProperty("webdriver.chrome.driver", "D:/Driver/geckodriver.exe");
		System.out.println("WEb"); 

		//driver=new ChromeDriver();
		driver=new FirefoxDriver();
		Thread.sleep(5000);
 
		driver.get("https://epaysit.eftapme.com/FEESCRM/");
		System.out.println("CRM");
		

		Thread.sleep(10000);
		//Utilities.ExcelUtil.getTestData(ExcelUtil.TESTDATA_SHEET_PATH+"LoginTest"); 
		//System.out.println(ExcelUtil.TESTDATA_SHEET_PATH+"LoginTest"); 
		//driver.close(); 
	}  

}
