/**
 * 
 */
package com.gmail.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author nssindhe
 *
 * This class will store all the locators and methods of login page
 */
public class LoginPage {
	
	WebDriver driver;
	
	By username=By.id("Email");
	By nextButton=By.xpath("//input[@id='next']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		//driver.get(url);
	}
	
	public void typeUserName()
	{
		driver.findElement(username).sendKeys("copstester");
	}
	public void typeClickNext()
	{
		driver.findElement(nextButton).click();
	}
}
