package SELENIUM.SELENIUM_PROJECT;

import org.testng.annotations.Test;

import Utilities.ExcelUtil;

public class LoginClass extends BaseClass {    
	  
	//LoginTest obj=null;  
@Test(priority=1)
	public void logintest() throws Exception
	{ 
		LoginTest lgntst = new LoginTest(BaseClass.driver);
	 
		System.out.println("test");    
		
    
		lgntst.username.sendKeys("sdhara"); 
		Thread.sleep(1000);
		System.out.println("sleep");  
 
		lgntst.password.sendKeys("E2uga5q0#pk");     
		Thread.sleep(1000);   
		lgntst.Submit.click(); 
		
		HomePageClass hp=new HomePageClass();
		hp.HomePage(); 
		    
		  

	} 
	
}
