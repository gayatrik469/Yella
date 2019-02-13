package org.openqa.yalla.testcases;

import java.io.IOException;

import org.openqa.yalla.base.design.Annotations;
import org.openqa.yalla.utils.ReadExcel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginLogout extends Annotations{

	@BeforeTest(groups="smoke")
	public void setData() {
		testcaseName = "LoginLogout";
		testDec = "Create a new lead in leaftaps";
		author = "Sarath";
		category = "Smoke";
	}
	@Test(dataProvider="cldata" , groups="smoke")
	public void loginLogout(String cname, String fname, String lname) {
		
		click(locateElement("link", "Leads")); 
		click(locateElement("link", "Create Lead")); 
		clearAndType(locateElement("id", "createLeadForm_companyName"), cname);
		clearAndType(locateElement("id", "createLeadForm_firstName"), fname);
		clearAndType(locateElement("id", "createLeadForm_lastName"), lname);
		click(locateElement("class", "smallSubmit"));
	}
	@DataProvider(name="cldata")
	public Object[][] sendData() throws IOException
	{		
		return ReadExcel.excelData("cl");  
		
		
		
		
		
		
		
		
		/*Object[][] data = new Object[2][3];
		data[0][0]="Testleaf";
		data[0][1]="Balaji";
		data[0][2]="C";

		data[1][0]="Testleaf";
		data[1][1]="Koushik";
		data[1][2]="C";
		return data;*/				
	}
}