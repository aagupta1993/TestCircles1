package com.circles.Pages;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;

public class CirclesPage {
	
	WebDriver driver;
	
	By circlesLogo=By.xpath("//*[@id=\"st-container\"]/div/div/div[1]/div/div/div[1]/a/img");
	By checkout=By.xpath("//*[@id='site-navigation']/div[1]/div[3]/a[1]");
	By bar=By.xpath("//*[@id=\"st-trigger-effects\"]/button/img");
	public By myAccount=By.xpath(".//*[@id=\"st-container\"]/div/div/div[1]/div/div/div[2]/div/a[3]/div");
	By fbButton=By.xpath(".//*[@id='st-container']/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/span/button");
	By emailAdd=By.xpath("//*[@id='st-container']/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/form/div[3]/div/input");
	
	
	public CirclesPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickOnLogo()
	{
		driver.findElement(circlesLogo).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				

	}	
	public void clickOnCheckOut()
	{
		driver.findElement(checkout).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);				

	}
	
	public void clickOnBar()
	{		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				

		driver.findElement(bar).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);				

	}

	public void clickOnMyAccount()
	{	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);				

		driver.findElement(myAccount).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		
		WebElement emailId=driver.findElement(emailAdd);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",emailId);
		String testemail=emailId.getText();
		System.out.print(testemail);
	}
	public void clickOnFbButton()
	{
		driver.findElement(fbButton).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);				

	}
	
	

}

