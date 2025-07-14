package SELENIUM.SELENIUM_PROJECT;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider; 
import org.testng.annotations.Test;

import Utilities.ExcelUtil;

public class TestClass extends BaseClass{

	String sheetname="contactdata";	 
	String usname=""; 
	String pswd=""; 
	String desig;  
	String mobno;    
	static int m=0;
	//@Test(dataProvider="GetCRMTestData")    
	public void UpdateUser() throws Exception 
	{ 
		String Object [][]=null;
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
				//List<WebElement> userids=driver.findElements(By.xpath("//tbody[1]/tr/td[2]"));
				List<WebElement> userids=driver.findElements(By.xpath("//tbody[1]/tr/td[3]")); 

				System.out.println(userids.get(i).getText()+"userids");
				WebElement radiobtn=radiobutton.get(i);
				String username=userids.get(i).getText(); 
				String uname="Vrushali";            
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
		//EditUser(); 
		//GetCRMTestData1();
		Object[][] name=GetCRMTestData1();
		System.out.println(name+"00");  
		//System.out.println(name+"withoutarray");
		//System.out.println(Arrays.toString(name)+"arraystostring");
		//System.out.println(Arrays.deepToString(name)+"arraystodeepsting"); 

		//EditUser(Arrays.deepToString(name), Arrays.deepToString(name));
		EditUser1(name);
		//EditUser(name.toString());
		//addedit();
  
	} 
	
   
	@DataProvider(name="GetCRMTestData")    

	//@DataProvider 
	public  Object[][] GetCRMTestData1() throws InvalidFormatException
	{
		System.out.println("Data Called");
		String Object[][]=null;
		ExcelUtil exc= new ExcelUtil();
		Object[][] data =ExcelUtil.getTestData(sheetname); 
		System.out.println("testdata"); 
		/*Object data[][]= new Object[2][2];  
		data[0][0]="TestUser1";
		data[0][1]="TestPassword1";
		
		System.out.println("Test Data : "+data[0][0]);  
		/*Object data[][]=new Object[1][1]; 
		data[0][0]="TestUser1";
		data[0][1]="TestPassword1"; 
		data[1][0]="TestUser2";
		data[1][1]="TestPassword2";*/
		System.out.println("Test Data : "+data[0][0]);
		return data;  
	}   	    
	 
	
	
	  
 	
@Test(dataProvider="GetCRMTestData")    
public static void EditUser1( Object[][] name) throws Exception
{                                                                                                                                                                   

//String String_Array[][]=new String[1][1];

System.out.println("Usernarme String DATA :"+name.length);         

System.out.println("Usernarme TEST DATA :"+name[0][0]);   
System.out.println("Usernarme TEST DATA1 :"+name[1][0]+"name lenthgh:"+name.length);    
 
UpdateUserTest UPT =new UpdateUserTest(UpdateUserTest.driver);  
//UPT.UpdateUserDetails(uname, desig, mobno);    
int rowsize=name.length;
//String val=Username; 
//if(name.length>=0)
if(rowsize>=m) 
{   
 m++;  
	System.out.println(rowsize+"rowsize"+m+" "+"lineno");      
	
for(int j=0;j<name.length;j++) 
{     
	 // j++; 
	System.out.println(j+"lineno");       
 
for(int i=0; i<name[j].length;i++)
{ 
	//String teste= name[j][i]; 
	System.out.println(name[j][i]+"column"+Arrays.toString(name[i])+"tostring");         
	UPT.uname.clear();     
	UPT.uname.sendKeys(Arrays.toString(name[i]));    
	/*val.toCharArray(); 
	System.out.println(val.toCharArray()+"chararray"); 
	char c = val.charAt(i); 
   String s = new StringBuilder().append(c).toString();
    System.out.println("string"+s); */ 
	 
	//System.out.println("string"+Username.charAt(i)); 
    //UPT.uname.clear();     
   // UPT.uname.sendKeys(i);  
}//int i//  
}//int j// 

}//***if condition**//  

else
{ 
	
	System.out.println("next"+m);
	 
} 
	//UPT.uname.clear();   
	//UPT.uname.sendKeys(Username);  
	//UPT.desg.sendKeys(desig);  
	//UPT.mobno.sendKeys(mobno); 
	/*	Select Config = new Select(UPT.Config); 
	//Config.selectByIndex(2);
	Select Created =new Select(UPT.CreatedFor); 
	//Created.selectByIndex(1);
	Thread.sleep(2000);																																								
	//UPT.Update.click();   
}




/*@Test(dependsOnMethods = {"EditUser"})
 public void addedit()
 {
	 System.out.println("edituser");
 }
 */
	
} 
}