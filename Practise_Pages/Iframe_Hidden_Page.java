package Practise_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Iframe_Hidden_Page {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/Driver/geckodriver.exe");
		driver=new FirefoxDriver();
		//driver.get("https://jqueryui.com/toggle/");
		
		//Spinner & Toggle page//
		driver.get("https://jqueryui.com/spinner/");
		VerifyElement_Enable_DisplayedTest();
		

	}
	
	public static void VerifyElement_Enable_DisplayedTest() throws InterruptedException
	{
		System.out.println("switch");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']"))); 
		//Toogle Page:- Verify if Element is Displayed//
		Thread.sleep(2000);

		/*WebElement Displayedelement=driver.findElement(By.xpath("//div[@id='effect']"));
		Assert.assertFalse(Displayedelement.isDisplayed());
		System.out.println("Before clicking on button"+Displayedelement.isDisplayed());
		
		WebElement bttn=driver.findElement(By.xpath("//button[@class='ui-state-default ui-corner-all']"));
		bttn.click();
		Assert.assertTrue(Displayedelement.isDisplayed());
		System.out.println("After clicking on button"+Displayedelement.isDisplayed());
*/
		// Spinner Page:- Verify if Element is Disable or Enable//
		
		WebElement txtbox=driver.findElement(By.xpath("//input[@id='spinner']"));
		WebElement togglebttn=driver.findElement(By.xpath("//button[@id='disable']"));
		
		Assert.assertTrue(txtbox.isEnabled());
		System.out.println("Before clicking on button:-"+txtbox.isEnabled());
		
		togglebttn.click();
		Assert.assertFalse(txtbox.isEnabled()); 
		System.out.println("After clicking on button:-"+txtbox.isEnabled());

		//Extract weblelements from specific area//
		
	} 

}
