package SELENIUM.SELENIUM_PROJECT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomePageClass extends BaseClass{

	//public WebDriver drivers; 
	int abc;   
	//String usname=""; 
	@Test 
	public void HomePage() throws Exception
	{
		//HomePageTest hmpgtest = new HomePageTest(BaseClass.driver);
		HomePageTest hm = new HomePageTest(HomePageTest.driver);
		
		WebElement web= driver.findElement(By.xpath("//h6[.='Select environment to explore...']"));
		System.out.println(web.getText());
		Select s1 = new Select (hm.Dropdown);
		//s1.selectByIndex(3);
		s1.selectByVisibleText("Amazon");
		
		Thread.sleep(3000); 
		hm.Close.click();
		

		hm.UMangement.click();
		hm.CUser.click(); 
		//hm.Add.click();
		
	/*	unlock it when doing regression/
	 * CreateUserClass CUS=new CreateUserClass();
		CUS.CreateUser();*/
		
    // directly clling update user//
		
		/* Commenting the UPdate CLass to test Dataprovider   */
		/*UpdateUserClass UPC =new UpdateUserClass();
		UPC.SearchUser(abc);*/// old code of Update user to select multiple records from search button
		
		//UPC.SearchUsertxt();
		 
		
		TestClass TC= new TestClass();
		TC.UpdateUser();  
		//TC.EditUser(usname); 
		
	}
	
	
	
	
}
