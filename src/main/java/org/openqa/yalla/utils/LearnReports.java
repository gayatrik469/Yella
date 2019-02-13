package org.openqa.yalla.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnReports {

	
	public static void main(String[] args) throws IOException {
       //create html file
		//BS
		ExtentHtmlReporter html = 
				new ExtentHtmlReporter("./reports/result.html");		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html); 
		//BC
		ExtentTest test = extent.createTest("Login", "Login to leaftaps");
       	test.assignAuthor("Sarath");
        test.assignCategory("Smoke"); 
		//
        test.pass("Username entered successfully",
		MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img0.png").build());
        test.pass("Password entered successfully");
        test.pass("Login clicked successfully");
        
        //end report
        //AS
	    extent.flush();
	
	
	
	
	
	
	
	}

}








