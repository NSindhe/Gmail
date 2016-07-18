/**
 * 
 */
package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author nssindhe
 *
 */
public class UserName {

	public UserName(WebDriver drv){
		PageFactory.initElements(drv, this);
	}
	
	@FindBy(id="Email")	
	private WebElement userName;	
	public WebElement FirstPage(){
		return userName;
	}
	
	@FindBy(id="next")
	private WebElement nextButton;
	public WebElement ClickNext(){
		return nextButton;
	}
	
}
