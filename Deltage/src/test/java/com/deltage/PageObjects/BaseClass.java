package com.deltage.PageObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.deltage.Utilities.BrowserFactory;
import com.deltage.Utilities.ConfigDataProvider;
import com.deltage.Utilities.ExcelDataProvider;
import com.deltage.Utilities.Helper;


public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel; 
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuit(){
		
		Reporter.log("setting of the reports and test is getting ready", true);
		
		excel=new ExcelDataProvider();
		config =new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/Deltage_+"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("setting Done = Test can be started", true);

	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url){
		
		Reporter.log("Trying to start Browser and getting application ready", true);

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		//driver = BrowserFactory.startApplication(driver, browser, urlToBeTested);
		
		Reporter.log("Browser and Applicatin is up and Running", true);

	}
	
	@AfterClass
	public void teardown(){
		BrowserFactory.quiteBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException{
		
		Reporter.log("Test is about to end", true);

		
		if (result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		    logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.fail("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
	/*	
	   else if(result.getStatus()==ITestResult.SKIP) {
			logger.fail("Test Skipped ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
	*/	
		report.flush();
		
		Reporter.log("Test completed >>> Reports Generated", true);

		
	}
	

}
