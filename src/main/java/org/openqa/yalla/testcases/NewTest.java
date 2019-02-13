package org.openqa.yalla.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class NewTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("password"); 
		WebElement eleLogin = driver.findElementByClassName("decorativeSubmit");
		File src = eleLogin.getScreenshotAs(OutputType.FILE);
		File dec = new File("./snaps/img1.png");
		FileUtils.copyFile(src, dec);

		/*AShot aShot = new AShot();
		Screenshot src = aShot.shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		try {
			ImageIO.write(src.getImage(),"PNG",new File("./snaps/img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*File src = driver.getScreenshotAs(OutputType.FILE);
		File dec = new File("./snaps/img.png");
		FileUtils.copyFile(src, dec);*/

	}

}


