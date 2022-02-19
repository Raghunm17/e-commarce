package com.deltage.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		this.ldriver=rdriver;
	}
	
	@FindBy(name="username")WebElement uname;
	@FindBy(name="pwd")WebElement pass;
	@FindBy(xpath="//a[@id='loginButton']")WebElement loginButton;
	
	@FindBy(xpath=("//a[@class='logout']"))WebElement logOutButton;
	
	
    public void loginToDeltage(String ussernameApplication, String passwordApplication) {
    	try {
    		Thread.sleep(2000);
    	}catch(Exception e) {
    		System.out.println("");
    	}
    	
    	uname.sendKeys(ussernameApplication);
    	pass.sendKeys(passwordApplication);
    	loginButton.click();
    	
    	
    	
    	logOutButton.click();
	
	}



	
/*
	public void setUserName(String ussernameApplication){
		uname.sendKeys(ussernameApplication);
	}
	
	public void setPassword(String passwordApplication){
		pass.sendKeys(passwordApplication);
	}
	
	public void clickSubmit(){
		loginButton.click();
	}
*/
	
	
	/*public void clickLogout()
	{
		
	}*/
}
