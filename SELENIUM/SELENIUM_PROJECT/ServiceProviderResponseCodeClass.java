package SELENIUM.SELENIUM_PROJECT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServiceProviderResponseCodeClass extends BaseClass{
int temps;
int nxt;
@Test
public void ClickMenu()
{
	System.out.println("click");
	ServiceProviderResponseCodeTest SPRC= new ServiceProviderResponseCodeTest(ServiceProviderResponseCodeTest.driver);
	SPRC.ServiceConfiguration.click();
	SPRC.ServiceProviderrspcode.click();
	
} 

@Test
public void Search()
{
	System.out.println("Serach");

	ServiceProviderResponseCodeTest SPRC= new ServiceProviderResponseCodeTest(ServiceProviderResponseCodeTest.driver);
	SPRC.Search.sendKeys("genius");
}

@Test
public void Pagination() throws InterruptedException
{
	ServiceProviderResponseCodeTest SPRC= new ServiceProviderResponseCodeTest(ServiceProviderResponseCodeTest.driver);
	Search();
	//List<WebElement> pages= driver.findElements(By.xpath("//div[@id='tblReport_paginate']/span/a"));
	int pagecount=SPRC.pages.size();
	int tablecount=SPRC.table.size();
	System.out.println("pagecount"+pagecount); 
	System.out.println("tablecount"+tablecount);
	String responsecode="US";
	if(pagecount>0)
	{
		for(int i=1;i<=pagecount;i++)
		{
			
			//pagecount=SPRC.pages.size(); 
			
			temps++;
			System.out.println(pagecount+"outer loop");
			Thread.sleep(5000);
			for(int j=1;j<=tablecount;j++)
			{
				 
			//List<WebElement> EuronetResponseCode= driver.findElements(By.xpath("//tbody[1]/tr["+j+"]/td[5]"));
			//List<WebElement> radio=driver.findElements(By.xpath("//tbody[1]/tr/td[1]"));
			//WebElement enrspcode= EuronetResponseCode.get(j);
			String enrspcode=driver.findElement(By.xpath("//tbody[1]/tr["+j+"]/td[5]")).getText();
			//WebElement radiobtn= radio.get(j);
			System.out.println("countinggg"+temps);   
			//if(nxt<=pagecount)
			//{
				
				if(enrspcode.contains(responsecode))
			{
				System.out.println("match response code"+enrspcode);
				Thread.sleep(5000); 

				driver.findElement(By.xpath("//tbody[1]/tr["+j+"]/td[1]")).click();
				Thread.sleep(5000); 
				View();
				
			
			} 
			else
			{
				System.out.println("rsptext"+enrspcode);
			}
			 
			//}//end if 
			}//tablecount for end
			
			nxt=temps+1;
			System.out.println(nxt+"nxtpage");
			driver.findElement(By.xpath("//a[.="+nxt+"]")).click();
			
		}//pagecount for end
	}
	

}//pagination end//

@Test
public void View() throws InterruptedException
{
	ServiceProviderResponseCodeTest SPRC = new ServiceProviderResponseCodeTest(ServiceProviderResponseCodeTest.driver);
	System.out.println("View");

	SPRC.View.click();
	Thread.sleep(2000);
	SPRC.Back.click();
	Search();
	Thread.sleep(2000);

}




}
