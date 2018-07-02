package com.circles.Pages;
import org.openqa.selenium.*;


/**
 * @author arun gupta
 *This class is used to store Locators of Login Page
 */
public class LoginPage {

	WebDriver driver;
	
	By email=By.id("email");
	By password=By.id("pass");
	By button=By.id("u_0_0");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void typeEmail(String emailId)
	{
		driver.findElement(email).sendKeys(emailId);
		
	}
	
	public void typePassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(button).click();
	}
}

