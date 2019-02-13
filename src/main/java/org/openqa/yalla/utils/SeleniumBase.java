package org.openqa.yalla.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.framework.api.Browser;
import org.openqa.framework.api.Element;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.yalla.utils.AdvanceReports;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SeleniumBase extends AdvanceReports implements Browser, Element{
	public int i=0;
	RemoteWebDriver driver = null;
	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			reportStep("The element "+ele+" clicked successfully","pass");
		} catch (WebDriverException e) {
			reportStep("The element "+ele+" not clicked","fail");
		} finally {
			takeSnap();
		}
	}

	@Override
	public void append(WebElement ele, String data) {


	}

	@Override
	public void clear(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data "+data+" entered successfully","pass");
		} catch (NullPointerException e) {
			reportStep("The data "+data+" not entered","fail");
		}
		catch (WebDriverException e) {
			reportStep("The data "+data+" not entered","fail");
		}
		finally {
			takeSnap();
		}
	}

	@Override
	public String getElementText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypedText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		Select sc = new Select(ele);
		sc.selectByVisibleText(value);
		System.out.println("The dropdown selected using VisibleText "+value); 
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startApp(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
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

	@Override
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch (locatorType) {
			case "id": return driver.findElementById(value);
			case "class": return driver.findElementByClassName(value);
			case "xpath": return driver.findElementByXPath(value);
			case "link": return driver.findElementByLinkText(value);
			}
			reportStep("The element with "+value+" located successfully","pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with "+value+" not located","fail");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> locateElements(String type, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void switchToAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void typeAlert(String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(String title) {
		Set<String> allwindows = driver.getWindowHandles();

		for (String eachWin : allwindows) {
			driver.switchTo().window(eachWin);

			if (driver.getTitle().equals(title)) {
				break;
			}
		}

	}

	@Override
	public void switchToFrame(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToFrame(String idOrName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void takeSnap() {

		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {

	}
	
}
