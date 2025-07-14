package Selenium_Test_Pages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Practise_Pages.Amazon_Add_Cart;
import Practise_Pages.BaseClass;

public class Amazon_Add_Cart_Test extends BaseClass{

	Amazon_Add_Cart amz;
	@BeforeClass
	public void Setup() throws IOException, InterruptedException
	{
		amz.Open();
		System.out.println("Opening");
	}
	
	@Test
	public void AddingtoCart() throws InterruptedException
	{
		amz.Click_on_Menu();
		amz.Click_AllVegetables();
		amz.Selectfrom_ListofItems();
	}
	
	@Test(enabled= false)
	public void SearchBox()
	{
		amz.SearchMenu("carrot");
		amz.Actions(driver);
	}
	
	@AfterClass
	public void TearDown()
	{
		amz.endReport();
	}
}
