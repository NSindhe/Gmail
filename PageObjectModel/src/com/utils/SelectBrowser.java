package com.utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelectBrowser {
	
	String brName;
	
	public WebDriver getBrowser()
	{
		WebDriver drv=null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Broweser Name");
		
		brName = sc.nextLine();
		switch(brName.toLowerCase()){
		
		case "firefox":
			drv = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdrive.ie.driver", "D:\\Selenium jars\\IEDriverServer.exe");
			drv = new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium jars\\chromedriver.exe");
			drv = new ChromeDriver();
			break;
		default: System.out.println("Invalide Driver so launching in Firefox");
			drv = new FirefoxDriver();
			break;
		}
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		drv.get(Constants.url);
		return drv;
	}

}
