package Practise_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Customized_Xpath {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Driver/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("HI"); 
		Thread.sleep(5000);
		//driver.get("https://www.amazon.in/");
		driver.get("https://www.javatpoint.com/");
		/*
		 * Amazon sites
		WebElement d1= driver.findElement(By.xpath("//div[@id='gw-layout']/div[2]/div/div/div/div/div/div/ul/li[3]"));
		*/
		
		//WebElement d1=driver.findElement(By.xpath("//div[@class='col-lg-12 section-content mb-5']/div/div[@class='courses-grid clients']/a[9]/div/div[div[@class='course-name' and contains(.,'Automation Anywhere')]"));
		try{
			//WebElement d1=driver.findElement(By.xpath("//*[contains(text(),'Automation Anywhere')]"));
			WebElement d1=driver.findElement(By.xpath("//div[@class='container']/div[@class='row']/div[4]/div/div/a[9]/div/div"));

			Thread.sleep(5000);  
			d1.click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	 /* 
	  * To find the checkbox of dynamic element eg 'QTP' from table
	  *  //td[text(),'QTP']/../td/input 
	  *  To find the parent we use "/.." where we get <tr> and after tat we find the checkbox data <td>
	  * */
		
	}

}
