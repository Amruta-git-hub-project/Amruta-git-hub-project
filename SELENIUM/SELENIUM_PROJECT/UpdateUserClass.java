package SELENIUM.SELENIUM_PROJECT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;

public class UpdateUserClass extends BaseClass { 
	//int temp=0;	 
	String sheetname="contactdata";	
	String usname="";  
	String desig;  
	String mobno; 

	@Test
	public void UpdateUser() throws InterruptedException 
	{
		
		UpdateUserTest UPT= new UpdateUserTest(UpdateUserTest.driver);

		System.out.println("updateuser");
		Thread.sleep(2000);
		List<WebElement> tablecount= UPT.table.findElements(By.xpath("tr"));
		int tablerow=tablecount.size();
		System.out.println(tablerow+"tablrow"); 

		if(tablerow>0) 
		{
			// And iterate over them, getting the cells 

			for(int i=0;i<tablerow;i++)
			{
				List<WebElement> radiobutton= driver.findElements(By.xpath("//tbody[1]/tr/td[1]"));
				List<WebElement> userids=driver.findElements(By.xpath("//tbody[1]/tr/td[2]"));

				//System.out.println(userids.get(i).getText()+"userids");
				WebElement radiobtn=radiobutton.get(i);
				String username=userids.get(i).getText(); 
				String uname="RPAMaker";
				//boolean test=false;
				if(username.contains(uname))
				{
					Thread.sleep(3000);
					radiobtn.click();

					//if(radiobtn.click())
					/*	{
						test=true;
						System.out.println(test);
						}*/
					System.out.println(username);

					break;

				}
				else
				{ 
					System.out.println("brk");
				}

			}

		} 

		Thread.sleep(3000); 
		UPT.btnedit.click(); 

	} 
	//Old Search multiple User Code//
	int temp=0;
	@Test
	
	public void SearchUser(int temp) throws InterruptedException, InvalidFormatException
	{  
		
		UpdateUserTest UPT= new UpdateUserTest(UpdateUserTest.driver);
		Thread.sleep(3000); 

		
		String searchname="NPrecision"; 
		WebElement Srchtxt= driver.findElement(By.xpath("//input[@id='SearchText']"));
		Srchtxt.sendKeys("NPrecision");   
		Thread.sleep(3000);    

		List<WebElement> opt= driver.findElements(By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']"));
		//List<WebElement> opt= UPT.search;  

		//System.out.println(driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']")).get(1).getText()+"list");   
		System.out.println(opt.size()+"list");  

		for(WebElement option: opt)   
		{  
			System.out.println(option.getText()+"listname"); 
			Thread.sleep(3000); 
			String nospaceoption= option.getText().replaceAll(" ", "");
			if(nospaceoption.equalsIgnoreCase(searchname))  
			{
				System.out.println(nospaceoption+"match"); 
				/*Thread.sleep(3000);
				Srchtxt.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(3000);
				System.out.println("down");
				Srchtxt.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				System.out.println(nospaceoption+"enter"); */
				option.click();
				Thread.sleep(3000);
				WebElement srchbtn= driver.findElement(By.xpath("//button[@id='btnSubmit']"));
				srchbtn.click(); 
				//break;
				List<WebElement> tablecount= UPT.table.findElements(By.xpath("tr"));
				int tablerow=tablecount.size();
				
				if(tablerow>1)  
				{

					//multiple_searchtext();
					//System.out.println(temp+"outertemp");
					if(tablerow!=temp)
					{
						multiple_searchtext();
						
						
					}
					else
					{
						System.out.println("outerbreak");
						//driver.navigate().to(driver.getCurrentUrl());
						break;	
					}
		
					
				} 
				else
				{
					System.out.println("1");
					Thread.sleep(3000);
					WebElement radiobtn= (WebElement) driver.findElement(By.xpath("//tbody[1]/tr/td[1]"));

					radiobtn.click();
					Thread.sleep(3000);  
					
			/*		try {
						//EditUser1();
						
					} catch (InvalidFormatException e) {
						e.printStackTrace();
					}*/
					 
					UPT.btnedit.click(); 

					EditUser(usname); 
					//UPT.btnview.click();
					//ViewUserClass VU= new ViewUserClass();
					//VU.ViewUser();
					Thread.sleep(3000); 
					ServiceProviderResponseCodeClass SPRC= new ServiceProviderResponseCodeClass();
					SPRC.ClickMenu();
					SPRC.Pagination();
				}

			}
			 
		}//opt
		
		
	}//end searchUSer

	public void multiple_searchtext() throws InterruptedException, InvalidFormatException

	{  
	 
		UpdateUserTest UPT= new UpdateUserTest(UpdateUserTest.driver); 

		List<WebElement> tablecount= UPT.table.findElements(By.xpath("tr"));
		int tablerow=tablecount.size();
		System.out.println(tablerow+"tablrow");
		
		for(int i=0;i<tablerow;i++)
		{  
			
			//List<WebElement> radiobutton= driver.findElements(By.xpath("//tbody/tr["+temp+"]/td/input"));
			//Random rnd=new Random();
			//	int rowindex= rnd.nextInt(tablerow+i++);
			System.out.println(tablerow+"fortblrw");

			System.out.println(temp+"temp");			
		
			if(tablerow>=temp) 
			{
				temp++;
				if(temp>tablerow)
				{
					ServiceProviderResponseCodeClass SPRC= new ServiceProviderResponseCodeClass();
					SPRC.ClickMenu();
					SPRC.Pagination();	  
				}
				else
				{
					driver.findElement(By.xpath("//tbody/tr["+temp+"]/td/input")).click();
					Thread.sleep(3000); 
					UPT.btnview.click(); 
					ViewUserClass VU= new ViewUserClass();
					VU.ViewUser();
					Thread.sleep(3000); 
					SearchUser(temp);
					
				}
				
				

			}
			else
			{
				System.out.println("break");
				//driver.navigate().to(driver.getCurrentUrl());
				
				break;
			} 
																																																				
			//break;
			
			

		}// end for   loop
		
	}// multiple_Search

	//Edit Code// 

	@DataProvider(name="GetCRMTestData")   

	public  Object[][] GetCRMTestData1() throws InvalidFormatException
	{
		//String Object[][]=null;
		ExcelUtil exc= new ExcelUtil();
		Object[][] data =ExcelUtil.getTestData(sheetname);
		System.out.println("testdata"); 
		//Object data[][]= ExcelUtil.getTestData(sheetname);
		return new Object[][]{{"Precisions"},{"Tester"}};  
	}   
	 
	
@Test(dataProvider="GetCRMTestData") 
	 
public void EditUser(String usname) throws InterruptedException, InvalidFormatException
{
	//GetCRMTestData(); 
System.out.println("Dataprovider");
UpdateUserTest UPT =new UpdateUserTest(UpdateUserTest.driver);
//UPT.UpdateUserDetails(uname, desig, mobno); 
System.out.println(usname+"edituser");

 
	UPT.uname.clear();
	UPT.uname.sendKeys(usname);  
	//UPT.desg.sendKeys(desig);  
	//UPT.mobno.sendKeys(mobno); 
	Select Config = new Select(UPT.Config); 
	Config.selectByIndex(2);
	Select Created =new Select(UPT.CreatedFor); 
	Created.selectByIndex(1);
	Thread.sleep(2000);																																								
	UPT.Update.click(); 
}	


  

public void EditUser1() throws InvalidFormatException
{
	System.out.println("edituser1"); 
	ExcelUtil exc= new ExcelUtil();
	Object[][] data =ExcelUtil.getTestData(sheetname);
	System.out.println(data.length);
}  
	
	
}

	