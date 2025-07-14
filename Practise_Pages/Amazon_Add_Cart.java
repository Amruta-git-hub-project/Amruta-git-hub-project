package Practise_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReport;
import junit.framework.Assert; 

public class Amazon_Add_Cart extends BaseClass {

	public  String ChildwindowHandles;
	public boolean greendotverify=false;
	 // Store the parent window handle 
	//public String parentWindow = driver.getWindowHandle();
	public  Amazon_Add_Cart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Open() throws IOException, InterruptedException {
		logger = report.createTest("TestOne");
		
		logger.log(Status.INFO, "Initializing the Browser");
		invokeBrowser("mozilla");
		OpenURL("websitename");
		logger.log	(Status.INFO, "Opening URL");
		Thread.sleep(2000);
		System.out.println("cc"); 
		//Click_on_Menu();
		//Click_AllVegetables();
		//Selectfrom_ListofItems();
		//SearchMenu();
		// tearDown();

	}
	public void Click_on_Menu() throws InterruptedException
	{
		

		logger = report.createTest("Click on FreshMenu");

		WaitForElementtoClick("Freshmenuclick_Xpath");
		elementClick("Freshmenuclick_Xpath");
		System.out.println("clicked");

		Thread.sleep(2000);

		/*
		 * elementClick("Skip_Xpath"); System.out.println("Cliccked");
		 * Thread.sleep(1000);
		 */

		driver.navigate().to(driver.getCurrentUrl());
		elementClick("Fruits_Veg_Xpath");
	}
	
	public void Click_AllVegetables()
	{
		logger = report.createTest("Click on AllVegetables");
		elementClick("All_Vegetables_Xpath"); 
		
	}
	
	public boolean Selectfrom_ListofItems()
	{
		logger = report.createTest("Select from ListofItems");
		System.out.println(getElement("Search_Xpath").getAttribute("value")+"attribut value"); 
		String ele=getElement("Search_Xpath").getAttribute("value");
		String fresh_veg="fresh vegetables";
		System.out.println(ele+"print element");
		boolean dotlist=false;
		boolean listofitems=false;
		int j=0;
		boolean sizeofwindows=false;

	
		List<WebElement>Vegetablelist= new ArrayList<WebElement>();
		//if(ele==fresh_veg) 
		if(ele.equals(fresh_veg))
		{
			Vegetablelist=getElements("DotList_Xpath"); 
			System.out.println("list"+ele);
			dotlist=true;
		}
		else
		{
			Vegetablelist=getElements("ListofItems_Xpath"); 
			System.out.println("else"+ele); 
			listofitems=true;

		} 
		String []items={"Fresh Potato","Fresh Cucumber"}; 
		String item1="Onion";  
		if(Vegetablelist.size()>0)
		{
			System.out.println("loade"+Vegetablelist.size());
			for(int i=0;i<Vegetablelist.size();i++)
			{
				String reg="-";
				String[] name=Vegetablelist.get(i).getText().split(",");
				

				//String first=name[0].trim().replace("Fresh", "").replace("-", "");
				String first=name[0].trim();
				List<String> itemsneeded= Arrays.asList(items); 
				//System.out.println("first sentenece"+first); 
				
				j++;
				
			     // Get all window handles
		        //Set<String> windowHandles = driver.getWindowHandles();
				//TO get one window handles
				// String parentWindow = driver.getWindowHandle();
				
		        //ArrayList<String> tabs = new ArrayList<String>(windowHandles);//to get all window handles
				// Get all window handles
			        //Set<String> allWindows = driver.getWindowHandles();
				 
				//if(itemsneeded.contains(first)&& first !=" ")//if there are arraylist
				if(compareString(item1,first)==true && first !=" ") 
				{ 	
					System.out.println("equal"+name[0]);
					//if(!isElementDisplayed("Greendot_Xpath"))
					if(dotlist==false && listofitems==true)
					{
						getElements("Add_Veg_Xpath").get(i).click();
						System.out.println(greendotverify+"Nogreendot");

					}
					else
					{
						 // Store the parent window handle 
						String parentWindow = driver.getWindowHandle();
						 // Click on a button that opens a new tab
							getElements("DotList_Xpath").get(i).click();
							greendotverify=true;
							System.out.println(greendotverify+"greendot");

							// Wait for tabs to open (optional sleep or explicit wait)
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("wait..");

					        // Get all window handles
							Set<String> allWindows = driver.getWindowHandles();

							  // Switch to the child window
						    for (String windowHandle : allWindows) {
						        if (!windowHandle.equals(parentWindow)) {
						        	ChildwindowHandles=windowHandle;
						            driver.switchTo().window(ChildwindowHandles);
						            if(allWindows.size()>0)
						            {
						            	System.out.println(allWindows.size()+"Size of window");
						            	 sizeofwindows=true;
						            
						           
									System.out.println(driver.getTitle()+"child tab");
									//Greendot_Cart(driver);  
						            }
						           //break;  
						        }
						        else
						        {
						        	System.out.println(driver.getTitle()+"parent tab");
						        	//driver.switchTo().defaultContent();
						        	driver.switchTo().window(parentWindow);
						        	

						        }
						       
								System.out.println(driver.getTitle()+"next child tab");
								System.out.println("flag"+sizeofwindows);
								//Greendot_Cart(driver); 
								//break;
								
								return sizeofwindows;
						    } 
						
						
	
					}//else
					
					/*****below code  to get only one item from arraylist*******/
					/*if(j>=itemsneeded.size())
					{
						break;
					}*/  
				
				}
				
				//greendotverifyFlag(greendotverify);
			} 
		}
		//greendotverifyFlag(greendotverify);
		return sizeofwindows;
	}
	
	public boolean greendotverifyFlag() {
		System.out.println(greendotverify+"verify");
		return greendotverify;
	}

	
	public Green_dot_Add_Cart_Page Greendot_Cart(WebDriver driver)
	{
		driver.switchTo().window(ChildwindowHandles);
		System.out.println(driver.getTitle()+"gettiless");
		return PageFactory.initElements(driver, Green_dot_Add_Cart_Page.class);
		//Green_dot_Add_Cart_Page gnp= new Green_dot_Add_Cart_Page(driver);
		//gnp.Add_Cart_btn(); 

	}
	
	public Green_dot_Add_Cart_Page Greendot_Cart2()
	{
		driver.switchTo().defaultContent();
		//driver.switchTo().window(parentWindow); 
		System.out.println(driver.getTitle()+"gettiless");
		return PageFactory.initElements(driver, Green_dot_Add_Cart_Page.class);
	}
	
	public Final_Add_to_Cart Click_on_Cart() 
	{
		System.out.println("Click on Cart...");

 
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
	
	public void SearchMenu(String input)
	{
		logger = report.createTest("SearchMenu");

		
	/*	String ele=getElement("Search_Xpath").getAttribute("value");
		String fresh_veg="fresh vegetables";
		if(ele.equals(fresh_veg))
		{*/
			//String input="carrot";
			getElement("Search_Xpath").clear();
			enterText("Search_Xpath",input);
			List<WebElement>Searchoption= getElements("AutoSuggestivedrpdwn_Xpath");
			//System.out.println(Searchoption.get(1).getText()+"Searchoption");
			for(WebElement options:Searchoption)
			{
				System.out.println(options.getText()+"getdropdowlist text");
				if(options.getText().equalsIgnoreCase(input))
				{
					System.out.println("ddd");

					/*Actions ac= Actions(driver);
					ac.moveToElement(options).keyDown(Keys.CONTROL).click();*/
					getElement("Search_Xpath").sendKeys(Keys.ARROW_DOWN);
					elementClick("Search");
				}
				
			}
			
			/*JavascriptExecutor exe = (JavascriptExecutor)driver;
			exe.executeScript("window.document.getElementById("ar").setAttribute('value', ' ')");
			*/
		//}	
		
	}
	

	

	public Actions Actions(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterTest

	public void endReport() {
		report.flush();
	}


	

}
