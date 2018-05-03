package com.cruz;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class TestSMH {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	
	@BeforeTest
	public void Setup()  {
		
		capabilities.setCapability("deviceName", "iphone X");
		capabilities.setCapability("autoLaunch", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("udid", "03C5652F-5A87-40FA-AFF4-7D4BE96F2D31");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("platformVersion", "11.3");
		capabilities.setCapability("bundleid", "com.tc.smh.dev");
		capabilities.setCapability("app", "/Users/sandeep/Desktop/Appfile/SmartMobilityHUB.app");
		
	
		
	}
	public RemoteWebDriver getDriver()throws MalformedURLException
	{
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities) ;
		return driver;
	}
	

	
	
	@Test
	public void clickOnNearMe() throws MalformedURLException{
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities) ;
		
		SMH_MHubPOM smh= new SMH_MHubPOM(this.getDriver());
		//SignIn SI=new SignIn(this.getDriver());
		smh.clickOnAllow();
		//SI.signInToApp();
		
		//smh.clickSignIn();
		smh.SearchGarage();
		smh.BookGarage();
		smh.ExtendReservation();
		smh.ParkingHistory();
	}
	

}
