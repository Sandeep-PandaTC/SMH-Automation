package com.cruz;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;

public class SMH_MHubPOM {
	
	public static String appname = "SMH-SmartHub";
	
	RemoteWebDriver driver;
	/*By SignIn=By.name("Sign In");
	By SignInUName=By.xpath("//XCUIElementTypeApplication[@name=\"SMH-Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField/XCUIElementTypeTextField");
	By SignInPwd= By.xpath("//XCUIElementTypeApplication[@name=\"SMH-Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeSecureTextField/XCUIElementTypeSecureTextField");
	By ForgotPwd*/
	By nearMe=By.name("Near Me");
	By search=By.xpath("//XCUIElementTypeApplication[@name=\"SMH-Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTabBar/XCUIElementTypeButton[1]");
	By wallet=By.xpath("//XCUIElementTypeApplication[@name=\\\"SMH-Dev\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTabBar/XCUIElementTypeButton[2]");
	By account=By.xpath("//XCUIElementTypeApplication[@name=\\\"SMH-Dev\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTabBar/XCUIElementTypeButton[3]");
	By garrage=By.xpath("");
	ExcelSheetStore excelsheetstore = new ExcelSheetStore(appname);
	

	public SMH_MHubPOM(RemoteWebDriver driver) {
	
		this.driver = driver;
	}

	
	public void clickOnAllow() {
		int i=0;
		do {
		if(driver.findElements(By.name("Always Allow")).size()==1)
			driver.findElement(By.name("Always Allow")).click();
			
		System.out.println("Turned on SMH App notification & Location settings");
		if(driver.findElements(By.name("Allow")).size()==1)
		driver.findElement(By.name("Allow")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		i++;
		System.out.println(i);
	}while((driver.findElements(By.name("Always Allow")).size()==1)||(driver.findElements(By.name("Allow")).size()==1));
	}
	
@Test(priority = 1)
	public void SearchGarage() {
		try {
			ExcelSheetStore.startTimer();
		//driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign In\"]")).click();
		//Assert.assertTrue(driver.findElement(nearMe).isDisplayed());
		//driver.findElement(nearMe).click();
		
		// Setting mock location
		  //Location location = new Location(32.7767, -96.7970, 131);
		  //driver.setLocation(location);
		//driver.findElement(nearMe).sendKeys("40.7484, -73.9857");
		//driver.findElement(nearMe).sendKeys("32.7767, -96.7970");
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Empire State Building\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"1201 Elm St. - Renaissance Tower - Garage\"]")).click();
		//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"54 W 31st St. - Valet (1251 Broadway Lot)\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Park Here\"]")).isDisplayed();
		System.out.println("Garage is Searched");
		ExcelSheetStore.stopTimer();
		ExcelSheetStore.enterSuccessData("SearchGarage");
		}
		catch(Exception ex) {
			ExcelSheetStore.stopTimer();
			ExcelSheetStore.enterFailureData("SearchGarage");
			ex.printStackTrace();
			
		}
		
}
@Test(priority = 2)
public void BookGarage() 
{
	try {
		ExcelSheetStore.startTimer();
	
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Park Here\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Cancel\"]//following::XCUIElementTypeTable//following-sibling::XCUIElementTypeButton")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Pay\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Time Remaining\"]")).isDisplayed();
		System.out.println("Garage is booked");
	}
	catch(Exception ex) {
		ExcelSheetStore.stopTimer();
		ExcelSheetStore.enterFailureData("BookGarage");
		ex.printStackTrace();
}
	}
@Test(priority = 3)
public void ExtendReservation()
{
	try {
		ExcelSheetStore.startTimer();
		//driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]")).click();
		
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Time Remaining\"]")).click();
		/*scrollObject.put("predicateString", "label == 'elementLabel'");
		driver.executeScript("mobile:scroll", scrollObject);*/
		RemoteWebElement element = (RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		//scrollObject.put("element", elementID); // Only for ‘scroll in element’
		scrollObject.put("direction", "down");
		driver.executeScript("mobile:scroll", scrollObject);
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Extend Time\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"15 Minutes ($9.00)\"]")).click();
		//driver.findElement(By.xpath("//15 Minutes")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Pay\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Time Remaining\"]")).isDisplayed();
		System.out.println("Booking for the garage is extended");
	}
	catch(Exception ex) {
		ExcelSheetStore.stopTimer();
		ExcelSheetStore.enterFailureData("ExtendReservation");
		ex.printStackTrace();
}
}
@Test(priority = 4)
public void ParkingHistory()
{
	try {
		ExcelSheetStore.startTimer();
		
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Time Remaining\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"SMH-Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTabBar/XCUIElementTypeButton[1]")).click();
		
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"SMH-Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTabBar/XCUIElementTypeButton[2]")).click();
		
		System.out.println("parking History is displayed");
		/*RemoteWebElement element1 = (RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
		String elementID1 = element1.getId();
		HashMap<String, String> scrollObject1 = new HashMap<String, String>();
		//scrollObject.put("element", elementID); // Only for ‘scroll in element’
		scrollObject1.put("direction", "down");
		driver.executeScript("mobile:scroll", scrollObject1);
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\" Crocker Garage Valet\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Re-Reserve Spot\"]")).click();*/
	}
	catch(Exception ex) {
		ExcelSheetStore.stopTimer();
		ExcelSheetStore.enterFailureData("ParkingHistory");
		ex.printStackTrace();
}
		
	}
	
}