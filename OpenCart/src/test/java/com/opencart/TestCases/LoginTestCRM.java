package com.opencart.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.opencart.PageObjects.BaseClass;
import com.opencart.PageObjects.LoginPage;



public class LoginTestCRM extends BaseClass{

   
	@Test(priority=1)
	public void loginApp() {
		
		logger=report.createTest("Login to Application");
		
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToDeltage(excel.getStringData("Login", 1, 0),excel.getStringData("Login", 1, 1));
		
		logger.pass("Login Success");

	}
	
	/*@Test(priority=2)
	public void loginApp1() {
		
		logger=report.createTest("Logout to CRM");
		
		logger.fail("Login failed");

	}
*/
}
 