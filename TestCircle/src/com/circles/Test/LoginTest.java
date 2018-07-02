package com.circles.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.circles.Pages.CirclesPage;
import com.circles.Pages.FacebookTest;
import com.circles.Pages.LoginPage;

public class LoginTest {
	public WebDriver driver;

	@BeforeTest
	public void setup() throws Exception
	{
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");
		String driverpath = "C:\\Driver\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

	}

	@Test(priority=1)
	public void validLogin() {
		driver.get("https://shop.circles.life/login?reset=true");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String firstWinHandle = driver.getWindowHandle();

		CirclesPage cp1 = new CirclesPage(driver);
		cp1.clickOnFbButton();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Set<String> handles = driver.getWindowHandles();
		handles.remove(firstWinHandle);
		Iterator<String> winHandle = handles.iterator();
		LoginPage lp = new LoginPage(driver);

		while (winHandle.hasNext()) {
			String secondWinHandle = winHandle.next();
			if (!firstWinHandle.equalsIgnoreCase(secondWinHandle)) {
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				lp.typeEmail("jamesjain1212@gmail.com");
				lp.typePassword("Testdata");
				lp.clickOnLogin();
			}
		}

		// handles.remove(secondWinHandle);
		driver.switchTo().window(firstWinHandle);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if ((driver.findElement(By.xpath(".//*[@id=\"st-container\"]/div/div/div[1]/div/div/div[2]/div/a[3]/div")))
				.isDisplayed()) {
			CirclesPage cp = new CirclesPage(driver);

			cp.clickOnMyAccount();
		} else {
			System.out.print("Element is not Getting Displayed for the time waited so skipping the test");
		}

	}
	
	@Test(priority=2)
	public void facebookTest() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		FacebookTest fbt=new FacebookTest(driver);
		

	    fbt.clickOnFirst();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		fbt.inputComment("Test Comment");

		fbt.clickOnPost();
		
		
	}

	@AfterTest

	public void closeConnection() throws Exception
	{
		driver.close();
		driver.manage().deleteAllCookies();
	}

}
