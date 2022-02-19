package com.opencart.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	// Screenshots, alerts, frames, windows, sync, issue, javaScript executer
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath=System.getProperty("user,dir")+ "/screenshots/Deltage _"  + getCurrentDateTime() +  ".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("captured the screen shots");
			
		} catch (IOException e) {
			System.out.println("unable to capture the screen shots>>"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat custumFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return custumFormat.format(currentDate);
	}
}
