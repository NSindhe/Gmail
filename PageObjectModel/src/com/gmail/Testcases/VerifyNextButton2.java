/**
 * 
 */
package com.gmail.Testcases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pageFactory.UserName;
import com.utils.ExcellUtils;
import com.utils.SelectBrowser;
import com.utils.SendKeys;

/**
 * @author nssindhe
 *
 */
public class VerifyNextButton2 {
	
	ExcellUtils exc;
	SelectBrowser browser;
	
	WebDriver drv;
	
		
	@BeforeMethod
	public void beforeMethod(){
		exc = new ExcellUtils();
		browser = new SelectBrowser();
	}
	

	@Test
	public void verifyValidateNext() throws InterruptedException
	{
		XSSFSheet sht = exc.getExcelValue("D:\\Logs\\Credentials.xlsx", "Sheet1");
		drv=browser.getBrowser();
		String userName = exc.getField(sht, 1, 0);
		System.out.println("drive : "+drv);
		SendKeys keys=new SendKeys(drv,userName);
		//UserName uname = new UserName(drv);
		System.out.println(userName);
	
		//uname.FirstPage().sendKeys(userName);
		//uname.ClickNext().click();
		
		
	}
	
	@AfterMethod
	public void afterMethod(){
		//drv.close();
		drv.quit();
	}
}
