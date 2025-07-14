package SELENIUM.SELENIUM_PROJECT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo {

	
	/*@DataProvider(name="TestData")
	public Object[][] getData()
	{
		Object data[][]=new Object[2][2];
		data[0][0]="TestUser1";
		data[0][1]="TestPassword1";
		data[1][0]="TestUser2";
		data[1][1]="TestPassword2";
	
		
		return data;
	}
	
	@Test(dataProvider="TestData")
	public void UserData(String username,String Password)
	{
		System.out.println("Username :"+username +" Password :-"+Password);
	}*/
	
	
	 @Test(dataProvider = "Sender")   
	    public void Receiver(String first, String second)
	    {
	        System.out.print(first+"first");
	        //System.out.print(second+"second"); 
	    }

	    @DataProvider
	    public Object[][] Sender() 
	    { 
	        Object[][] data = new Object[2][2];  
	        data[0][0] = "a"; 
	        data[0][1] = "b";  
	        //data[1][0] = "c"; 
	        //data[1][1] = "d";
	        return data; 
	    } 
	
	
	
}


