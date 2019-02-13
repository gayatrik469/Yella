package org.openqa.yalla.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.yalla.base.SeleniumBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends SeleniumBase{
	@BeforeTest
	public void setData() {
		testcaseName = "CreateLead";
		testDec = "Create a new lead in leaftaps";
		author = "Sarath";
		category = "Smoke";
	}
	public RemoteWebDriver driver = null;
	public void startApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.driver", "./drivers/safaridriver.exe");
				driver = new SafariDriver();
			} 
			driver.manage().window().maximize();
			driver.get(url); 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			reportStep("The browser "+browser+" launched successfully","pass");
		} catch (WebDriverException e) {
			reportStep("The browser "+browser+" not launched","fail");
		}
		finally {
			takeSnap();
		}
	}
	@Test
	public void login() {
		super.startApp("", ""); 
		startApp("chrome", "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_aside");
		switchToFrame("iframeResult");
		WebElement locateElement = locateElement("tagname", "aside");
		System.out.println(locateElement.getText());
	}
}




