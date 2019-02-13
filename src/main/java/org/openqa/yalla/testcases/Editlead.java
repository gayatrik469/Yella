package org.openqa.yalla.testcases;

import org.openqa.yalla.base.design.Annotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Editlead extends Annotations{
	@BeforeTest(groups="any")
	public void setData() {
		testcaseName = "Editlead";
		testDec = "Create a new lead in leaftaps";
		author = "Sarath";
		category = "Smoke";
	}

	@Test(groups="function1") 
	public void editlead() {
        click(locateElement("link", "Create Lead"));
        clearAndType(locateElement("id", "createLeadForm_companyName"), "TL");
        clearAndType(locateElement("id", "createLeadForm_firstName"), "Gayatri");
        clearAndType(locateElement("id", "createLeadForm_lastName"), "K");
        click(locateElement("class", "smallSubmit"));
        
	}
}




