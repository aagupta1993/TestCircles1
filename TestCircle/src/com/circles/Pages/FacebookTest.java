package com.circles.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTest {

	WebDriver driver;
	By first = By.xpath("//*[@id='js_4']/div/div/div[1]/div[1]/h1/a/span");
	By commentSection = By.name("xhpc_message");

	By commentSection1 = By.xpath("//*[starts-with(@id,'js_')] && //*[ends-with(@id,'m')]");
	By button = By.xpath("//button[contains(.,'post')]");

	public FacebookTest(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnFirst() {
		driver.findElement(first).click();
	}

	public void inputComment(String comment) throws InterruptedException {
		// driver.findElement(commentSection).click();
		driver.findElement(button).sendKeys(comment);
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public void clickOnPost() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(button));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(button).click();
	}

}
