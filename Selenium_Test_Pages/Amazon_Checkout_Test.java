package Selenium_Test_Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Practise_Pages.Amazon_Add_Cart;
import Practise_Pages.BaseClass;
import Practise_Pages.Final_Add_to_Cart;
import Practise_Pages.Green_dot_Add_Cart_Page;
import Practise_Pages.Homes_Kitchen_Page;
import Practise_Pages.Navigates_Items;
import junit.framework.Assert;

public class Amazon_Checkout_Test extends BaseClass {
	
	//WebDriver driver;
	//Final_Add_to_Cart fac= new Final_Add_to_Cart(driver);
	
	
	Amazon_Add_Cart amz;
	Final_Add_to_Cart fac;
	Green_dot_Add_Cart_Page gnp;
	Homes_Kitchen_Page hkp;
	Navigates_Items nvg;
	
	@BeforeClass
	public void initializefirst() throws IOException, InterruptedException
	{
		BaseClass bs=new BaseClass();
		amz=bs.clickin();
		amz.Open();
		

		//fac.initialize();
		System.out.println("Opening Checkout");

	} 
	
	@Test
	public void AddingtoCart() throws InterruptedException
	{
		amz.Click_on_Menu();
		amz.Click_AllVegetables();
		boolean flag=amz.Selectfrom_ListofItems();
		boolean verify=amz.greendotverifyFlag();
		
		System.out.println(verify+"greendotverifyFlag"); 
		System.out.println(flag+"flag"); 

		
		if(flag==true && verify==true)
		{
			gnp=amz.Greendot_Cart(driver);
			gnp.Add_Cart_btn();
			fac=gnp.Click_on_Cart1(); 
		}
		
			
		else if(flag==false && verify==true)
			{
			gnp=amz.Greendot_Cart2();
				gnp.Add_Cart_btn();
				fac=gnp.Click_on_Cart1(); 
			}
			
			

		
		//******Fix thiss***/////
		else if(flag==false && verify==false)
		{
			fac=amz.Click_on_Cart(); 
		}

	} 

	@Test(enabled= false)
	public void GreenbtnClickonCart()
	{
		gnp.Add_Cart_btn();
	}
	
	@Test(enabled= false)
	public void SearchBox()
	{
		amz.SearchMenu("carrot");
		//amz.Actions(driver);
	}
	
	
	@Test
	public void Final_Checkout() throws InterruptedException
	{
		fac.GetNo_Item(); 
		fac.TotalImgCount(); 
		boolean searchresult=fac.VerifySize();
		Assert.assertTrue(searchresult);
	}
	
	@Test
	public void HOme_Kitchen() throws InterruptedException
	{
		hkp=fac.Navigate_HomeKitchen();
		hkp.HomeKitchen_Page();
		hkp.Result();
		nvg=hkp.Navigates_Page(); 
		nvg.New_Item();
		//nvg.Related_Products_Delivery();
		nvg.GetURL();
	}

	
	@AfterClass
	public void TearDown()
	{
		fac.endReport();
	}
	
	

}
