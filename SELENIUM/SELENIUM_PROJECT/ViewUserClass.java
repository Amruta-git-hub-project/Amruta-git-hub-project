package SELENIUM.SELENIUM_PROJECT;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ViewUserClass extends BaseClass{
@Test
	public void ViewUser()
	{
		System.out.println("view");
		driver.findElement(By.xpath("//div[@class='col-md-4']/a")).click();
		
	}
	
}
