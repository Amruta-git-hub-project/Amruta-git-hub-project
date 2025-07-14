package Practise_Pages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Amazon_Add_Cart_Test extends BaseClass {
	
	@BeforeClass
	public void Open() throws IOException, InterruptedException {
		logger = report.createTest("TestOne");

		logger.log(Status.INFO, "Initializing the Browser");
		invokeBrowser("mozilla");
		OpenURL("websitename");
		logger.log(Status.INFO, "Opening URL");
		Thread.sleep(2000);
		System.out.println("cc"); 
		WaitForElementtoClick("Freshmenuclick_Xpath");
		elementClick("Freshmenuclick_Xpath");
		System.out.println("clicked");

		Thread.sleep(2000);

		driver.navigate().to(driver.getCurrentUrl());
		elementClick("Fruits_Veg_Xpath");
		

	}
	
	@AfterClass
	public void endReport() {
		report.flush();
	}
	
}
