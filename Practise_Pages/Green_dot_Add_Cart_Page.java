package Practise_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Green_dot_Add_Cart_Page extends BaseClass {

	public Final_Add_to_Cart fac;
	public Green_dot_Add_Cart_Page(WebDriver driver)
	{
		this.driver=driver;
		//fac=PageFactory.initElements(driver, Final_Add_to_Cart.class);
		
	}
	
	public void  Add_Cart_btn() 
	{
		logger = report.createTest("Add_Cart_btn");
		System.out.println("Add_Cart_btn"); 
		System.out.println("Title"+driver.getTitle());
		//elementClick("Add_Cart_Greendot_Xpath"); 
	
		try {
			WebElement title= driver.findElement(By.xpath("//div[@id='titleSection']/h1/span[@id='productTitle']"));
			System.out.println(title.getText()+"---Title name");
			WebElement element1 = driver.findElement(By.xpath("//span[@id='freshAddToCartButton']"));
			Thread.sleep(5000);
			element1.click(); 
			System.out.println("clickked");
		} catch (InterruptedException e) {   
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		//return PageFactory.initElements(driver, Final_Add_to_Cart.class);
	}
	
	public Final_Add_to_Cart Click_on_Cart1() 
	{
		System.out.println("Click on Cart");

 
		logger=report.createTest("Click on Cart");

		try{
			WebElement element = driver.findElement(By.xpath("//div[@id='nav-belt']/div[@class='nav-right']/div/a[2]")); 
			element.click();
			System.out.println("Found..");

			/*JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);*/
		}
		catch(NoSuchElementException e)
		{
			System.out.println("not found"+e);
		}

		System.out.println("cleced");
		return PageFactory.initElements(driver, Final_Add_to_Cart.class);

	}
	

/*	public 	Final_Add_to_Cart Add_Cart()
	{
	return fac;
	}*/
}

