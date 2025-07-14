package Practise_Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homes_Kitchen_Page extends BaseClass {

	public static String  ChildWindowHandles;
	boolean flag=false;
	public Homes_Kitchen_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, BaseClass.class);
	}
	
	public void HomeKitchen_Page() throws InterruptedException
	{
		System.out.println(driver.getTitle()+"Title");
		logger= report.createTest("HOmeKitchenPage"); 
	
		//WaitForElementtoClick("HomeKitchen_Xpath");
		
		driver.findElement(By.xpath("//a[contains(text(),'Home & Kitchen')]")).click();
		Thread.sleep(2000);
		
		//To loop through all list //
		
		//List<WebElement>checkbox= driver.findElements(By.xpath("//div[contains(@class,'apb-browse-refinements-checkbox')]/label/input[@type='checkbox']"));
		
		try{
			List<WebElement>checkbox= driver.findElements(By.xpath("//div[contains(@class,'apb-browse-refinements-checkbox')]/following-sibling::span"));
			System.out.println(checkbox.get(1).getText()+"checkboxtext");	
	
		
		for(WebElement onecheckbox:checkbox)
		{ 
			//String checkvalue=onecheckbox.getAttribute("value");
			String checkvalue=onecheckbox.getText();
			//System.out.println(checkvalue+"checkvale");
			//WebElement chckbox=driver.findElement(By.xpath("//div[contains(@class,'apb-browse-refinements-checkbox')]/label/input[@type='checkbox']"));
			if(checkvalue.equals("MILTON"))
			{
				WebElement chckbox=driver.findElement(By.xpath("//input[contains(@aria-labelledby,'"+checkvalue+"')]"));

				System.out.println(checkvalue+"MILTONcheckvale");
				String val=chckbox.getAttribute("aria-labelledby");
				System.out.println(val+"chckboxval");
					

			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", chckbox);
				/*if(!chckbox.isSelected())
				{
					chckbox.click();
				}*/
				
				
			}
			
		}
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("not found"+e);
		}
	}
	
	
	public void Result()
	{
		try{
			
		
		List<WebElement> clickelement= driver.findElements(By.xpath("//div[contains(@class,'puis-padding-right-small')]/div/a[contains(@class,'a-text-normal')]"));
		
		String parentwindow= driver.getWindowHandle();
		for(WebElement tablegrid : clickelement)
		{
			String tblele = tablegrid.getText();
			if(tblele.contains("MILTON Executive Lunch Box"))
			{
				System.out.println(tblele+"eletext");
				
				//explicit wait//
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
				WebElement clickable =wait.until(ExpectedConditions.elementToBeClickable(tablegrid));
				//clickable.click();
				
 
		
				tablegrid.click();
				System.out.println("tablegrid");

				
				Set<String> childwindow= driver.getWindowHandles();
				
				for(String onewindow : childwindow)
				{
					if(!onewindow.equals(parentwindow))
					{
						ChildWindowHandles=onewindow;
						driver.switchTo().window(ChildWindowHandles);
						flag=true;
					}
					else
					{
						//driver.switchTo().defaultContent();
						driver.switchTo().window(parentwindow);
						flag=false;
						System.out.println("parentwindow");

					}
				}
				System.out.println("flag"+flag);
			}
		}
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("not foundd"+e);
		}
		
	}
	
	public Navigates_Items Navigates_Page()
	{
		if(flag==true)
		{
			driver.switchTo().window(ChildWindowHandles);

		}
		else
			driver.switchTo().defaultContent();

		driver.getTitle();
		return PageFactory.initElements(driver, Navigates_Items.class);
	}
	
}
