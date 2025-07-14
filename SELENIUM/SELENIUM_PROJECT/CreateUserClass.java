package SELENIUM.SELENIUM_PROJECT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateUserClass extends BaseClass{ 
	int abc;
	@Test 
	public void CreateUser() throws Exception
	{
		CreateUserTest CU =new CreateUserTest(CreateUserTest.driver);
		//System.out.println("user");
		WebDriverWait wait = new WebDriverWait(CreateUserTest.driver, Duration.ofMillis(2000)); 

		CU.Userid.sendKeys("Armita"); 
		CU.Username.sendKeys("Armita");
		CU.Designation.sendKeys("Tester");
		CU.MobileNo.sendKeys("9080987657");  
		CU.Email.sendKeys("ummaa12@gmail.com");

		CU.Role.sendKeys("Administrator");
		//wait.until(ExpectedConditions.elementToBeClickable(CU.Role)); 
		Thread.sleep(3000);

		System.out.println("type");
		//Thread.sleep(4000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		CU.Role.sendKeys(Keys.ARROW_DOWN); 
		//Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(CU.Role));  

		 CU.Role.sendKeys(Keys.ENTER);  
		Thread.sleep(3000);

		Select status =new Select(CU.Status);
		status.selectByVisibleText("Active");
		Select Config= new Select(CU.Configuration);
		Config.selectByIndex(3);
		Select Create= new Select(CU.Createdfor);
		String optiontoservice="0";
		String optionmerchant="0";
		String optionbranch="0";
		String optioncommonmerchant="commonmerchant";
		
		List<WebElement> cr= Create.getOptions();
		// cr.contains(Create.selectByVisibleText("serviceprovider"));
		for(int i=0;i<cr.size();i++) 
		{
			String optionval=cr.get(i).getText();
			System.out.println(optionval);
			
			if(optionval.contains(optiontoservice))
			{
				Create.selectByVisibleText("serviceprovider");
				CU.MerchantOrOperater.sendKeys("AMZ");
				//CU.Submit.click(); 
			}
			else if(optionval.contains(optionmerchant ))
			{
				Create.selectByVisibleText("merchant");
			 	CU.MerchantOrOperater.sendKeys("AMZ");
				//Thread.sleep(3000);
				CU.Storename.sendKeys("AMZ_01");
				//CU.Submit.click();
			}
			else if(optionval.contains(optioncommonmerchant))
			{
				Create.selectByVisibleText("commonmerchant");
				List<WebElement> rows= CU.tablerow.findElements(By.xpath("tr"));
				int count= rows.size(); 
				System.out.println(count+"rowss");
			
					CU.MerchantOrOperater.sendKeys("FLP -(FLP)");
					Thread.sleep(3000);
					System.out.println("FLP");

					CU.MerchantOrOperater.sendKeys(Keys.ARROW_DOWN);
					//Thread.sleep(3000);
				 	CU.MerchantOrOperater.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
			 		CU.btnadd.click();	
					Thread.sleep(3000);
					if(count!=2)
					{
					CU.MerchantOrOperater.clear();
					Config.selectByVisibleText("GooglePay");
					CU.MerchantOrOperater.sendKeys("FLP -(FLP)");
					Thread.sleep(3000);
					CU.MerchantOrOperater.sendKeys(Keys.ARROW_DOWN);
					//Thread.sleep(3000);
				 	CU.MerchantOrOperater.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
			/*		CU.MerchantOrOperater.sendKeys("Amazonpay -(AMZ)");
					Thread.sleep(3000);
					CU.MerchantOrOperater.sendKeys(Keys.ARROW_DOWN);
				 	CU.MerchantOrOperater.sendKeys(Keys.ENTER);*/
				
					CU.btnadd.click();
					CU.Submit.click();
					String response=CU.ResponseMsg.getText();
					System.out.println(response);
					if(response.equals("User already exists"))
					{
						System.out.println("duplicate");
						UpdateUserClass UPC =new UpdateUserClass();
						//UPC.UpdateUser();
						UPC.SearchUser(abc);
						//UPC.TestTrial();
					}
					else
					{
						System.out.println("success");
					}

				}
			 	
				else  
				{
					System.out.println("submit");

				}
				
			 	
			}
			
		
			else
			{
				System.out.println("end");
			} 
		}
		Thread.sleep(2000);
	
	/*	UpdateUserClass UPC =new UpdateUserClass();
		UPC.SearchUser();*/
	}
}
