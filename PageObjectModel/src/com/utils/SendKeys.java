package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pageFactory.UserName;

public class SendKeys {

	public SendKeys(WebDriver driver,String userName) throws InterruptedException{
		System.out.println("Uname : "+userName);
		System.out.println(driver);
		//driver.findElement(By.id("next")).click();
		UserName uname = new UserName(driver);
		uname.FirstPage().sendKeys(userName);
		Thread.sleep(2000);
		uname.ClickNext().click();
	}
}
