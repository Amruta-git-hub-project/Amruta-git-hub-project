package Utilities;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
 
public class ExtentReport {

	//public static ExtentHtmlReporter htmlReporter;
	public static  ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if( report==null)   
		{
			ExtentSparkReporter htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\testreport.html");
			report = new ExtentReports(); 
			report.attachReporter(htmlReporter);
			report.setSystemInfo("user", "amruta");
			htmlReporter.config().setDocumentTitle("UI Automation Report"); 
			htmlReporter.config().setReportName("All Headline UI Test Report");
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);  
			
			htmlReporter.config().setTimeStampFormat("MMM dd,yyyy HH:mm:ss");
		}
		return report; 
		
	}
}
