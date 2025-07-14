package Practise_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DatePicker {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Driver/geckodriver.exe");
		driver=new FirefoxDriver(); 
		//DatePicker//

		driver.get("https://jqueryui.com/datepicker/"); 
		System.out.println("sleep");
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement Datepicker= driver.findElement(By.xpath("//input[@id='datepicker']"));

		/*For simple method to select date from datepicker
		
		Datepicker.sendKeys("01/05/2024");  
		
		*/
		Datepicker.click();
		 

		Date_Calendar_1();

	}
	public static void Date_Calendar()
	{
		int count=0;
		WebElement dateWidget = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody"));
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		List<WebElement> months=driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement prev = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
		//WebElement monthcell=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		//System.out.println(month.get(0).getText()+"text");
/*	Datepicker using Javascript Executor 
 * ((JavascriptExecutor)driver).executeScript("document.getElementById('fromDate').setAttribute('value','10 Jan 2013')")

	//Second way to write day in datepicker//
	 	 
		JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@data-date='5']")));
       
*/		
		
		
		for(WebElement month : months)
		{
		
		   
		for (WebElement cell: columns){ 
		   //Select 13th Date 
		   /*if (cell.getText().equals("13")){
		      cell.findElement(By.linkText("13")).click();
		      break;
		 }*/
			System.out.println("columns"+cell);

		   if(month.getText().equals("February"))
			{
				prev.click();
				count ++;
				System.out.println("click"+month.getText());
	 
				if(month.getText().equals("December"))
				{
					System.out.println("monthclick");
					if (cell.getText().equals("13")){
					      cell.findElement(By.linkText("13")).click();
					break;
					}//if cell text
				}// if month text
				else
				{
					continue;
				}
				
			} 
	}
}

}



public static void Date_Calendar_1() throws InterruptedException
{
	WebElement dateWidget = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody"));
	List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

	for(int i=0;i<=columns.size();i++)
		{
		 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		 System.out.println(columns.size()+"colsize");
		
		 WebElement month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		 WebElement date= driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),13)]"));
			if(month.getText().equals("Decembers"))   
			{
				
				 if(date.getText().equals("13"))
				 {
					 System.out.println("13"+date.getText());
					 Thread.sleep(2000);
					 date.click();
				 }
					Assert.assertTrue(true);

				 break; 
				 	 
			} 
	
		}
	  
}
}


