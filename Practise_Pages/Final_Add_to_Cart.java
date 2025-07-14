package Practise_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class Final_Add_to_Cart extends BaseClass{
	//public static WebDriver driver;

	public Final_Add_to_Cart(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public boolean GetNo_Item()
	{ 
		logger=report.createTest("Getno_item");
		System.out.println("Getno_item");
		boolean flag=true;

		try{ 
			System.out.println("Child tab final"+ driver.getTitle());
			WebElement count=driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span[contains(@class,'nav-progressive-content')]"));
			String strcount=count.getText();
			System.out.println(count.getText()+"--gettext");
			if(strcount.equals("0"))
			{
				flag=false;
				System.out.println(flag+"GetNo_Item()");
			} 
			try {
				

				//elementClick("GetNoofItem_Xpath"); 
				WebElement cartclck=driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
				Thread.sleep(2000); 
				cartclck.click(); 

			} catch (InterruptedException e) {  
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Not found ");
			}
			
			//Assert.assertNotNull(strcount, "Cart is empty");	
		}
		catch(NoSuchElementException e)
		{
			System.out.println("not found"+e);
		}
		System.out.println(flag+"GetNo_Item flag");

		return flag;
	}
	
	public int TotalImgCount()
	{
		logger=report.createTest("TotalImgCount");
		List<WebElement> imgcount=driver.findElements(By.xpath("//div[contains(@class,'sc-collapsed-item-list')]/a/img"));
		//int imgcount= getElements("Total_Img_Xpath").size(); 
		System.out.println(imgcount.size()+"size of img");
		return imgcount.size();
	}
	
	public boolean VerifySize()
	{
		logger=report.createTest("VerifySize");
		boolean result=false;
		if(TotalImgCount()>0)
		{
			result=true;
			
		}
		result=GetNo_Item() && result; 
		System.out.println(result+"result");
		return result;

	}
	
	public Homes_Kitchen_Page Navigate_HomeKitchen()
	{
		return PageFactory.initElements(driver, Homes_Kitchen_Page.class);
	}
	
	public void endReport() {
		report.flush();
	}

	
}
