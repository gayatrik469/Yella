package org.openqa.yalla.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AdvanceReports {
	public ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testcaseName, testDec, author, category;
	@BeforeSuite(groups="any")
	public void startResult() { 
		html = new ExtentHtmlReporter("./reports/result.html");	
		html.setAppendExisting(true); 
		extent = new ExtentReports();
		extent.attachReporter(html); 
	}	
	@BeforeClass(groups="any")
	public void startTest() {
		test = extent.createTest(testcaseName, testDec);
       	test.assignAuthor(author);
        test.assignCategory(category); 
	}	
	public void reportStep(String dec, String status) { 
       if(status.equalsIgnoreCase("pass")) {
		test.pass(dec);
       }
       else  if(status.equalsIgnoreCase("fail")) {
        test.fail(dec);
        throw new RuntimeException();
       }
       else  if(status.equalsIgnoreCase("warning")) {
           test.warning(dec);
       }
	}  
	@AfterSuite(groups="any")
	public void endResult() {
	    extent.flush();
	}
	

}








