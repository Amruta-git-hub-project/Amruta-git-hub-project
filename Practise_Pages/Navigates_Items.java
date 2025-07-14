package Practise_Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigates_Items extends BaseClass{

	public Navigates_Items(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void New_Item() throws InterruptedException
	{
		System.out.println(driver.getTitle()+"get title");
		WebElement addtocart=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addtocart.click();
		
		//WebElement skip= driver.findElement(By.xpath("//span[@id='attachSiNoCoverage-announce']"));
		/* This code was when 'SKIP' button gets displayed
		 * JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", skip); */ 
		
		/*JavascriptExecutor js= (JavascriptExecutor)driver; 
		js.executeScript("window.history.go(-1)");*/
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000)); 

		driver.navigate().back(); 
		
	}
	
	public void Related_Products_Delivery()
	{
		int count=0;
		//int licount=0;
		List<WebElement> oldiv =driver.findElements(By.xpath("//div[ol]"));
		
		for(WebElement div : oldiv)
		{
			WebElement  divimg= div.findElement(By.tagName("ol"));
			if(!(divimg==null))
			{
				System.out.println(divimg.getText()+"get text");
				count++;
			if(count==3)
			{
				int licount=0;
				List<WebElement> lidiv= divimg.findElements(By.xpath(".//li[contains(@class,'a-carousel-card')]"));
				for(WebElement divli :lidiv)
				{
					
					licount++;
					System.out.println(divli.getText()+"lii"+licount); 

					//if(divli.getText().equalsIgnoreCase("THALA"))
					if(licount==3)
					{
						WebElement anchorname= driver.findElement(By.xpath("//a[contains(@id,'sp_detail_thematic-prime_theme_for_non_prime_members_')]"));

						System.out.println("prvus anchor click"); 

						anchorname.click();
						System.out.println("anchor click"); 

					}
					
				}
				
				break;
			}
			}
			
		}
		
	}
	
	public void GetURL()
	{
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

		WebElement ele=driver.findElement(By.xpath("//button[@onclick='alertFunction()']"));
		try {
			Thread.sleep(1000);
			ele.click();
			Alert alert= driver.switchTo().alert();
			alert.accept();
			System.out.println("alert");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		WebElement ele1=driver.findElement(By.id("confirmBox"));
		WebElement waitele=wait.until(ExpectedConditions.elementToBeClickable(ele1));
		waitele.click();
		//Alert alert1= driver.switchTo().alert();
		Alert alert1=wait.until(ExpectedConditions.alertIsPresent());
		String alert1txt=alert1.getText();
		alert1.dismiss();
		System.out.println(alert1txt);

		WebElement ele2=driver.findElement(By.cssSelector("button[onclick='promptFunction()']"));
		WebElement waitele2=wait.until(ExpectedConditions.elementToBeClickable(ele2));
		waitele2.click();
		Alert alert2= wait.until(ExpectedConditions.alertIsPresent());
		String alert2txt=alert2.getText();
		
		alert2.sendKeys("adfdf");
		System.out.println(alert2txt); 

	}
}
