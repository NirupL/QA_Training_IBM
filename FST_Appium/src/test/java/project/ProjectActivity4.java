package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity4 {
	//declare the objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//set the desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		//options to select platform
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		
		//use the appPackage and appActivity to open apps
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		
		//option to prevent app reset
		options.noReset();
		
		//set the Appium server url
		URL serverUrl = new URI("http://127.0.0.1:4723").toURL();
		
		//initialize the driver
		driver = new AndroidDriver(serverUrl, options);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test
	public void openToDoList() {
		//open the page
		driver.get("https://training-support.net/webelements");
		
		// Wait for elements to load
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text=\"Alerts\"]")));
		
		//scroll till the todo list
		PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
		Sequence scroll = new Sequence(finger,1);
		
		scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 475, 2064));
		scroll.addAction(finger.createPointerDown(0));
		scroll.addAction(finger.createPointerMove(Duration.ofMillis(100), Origin.viewport(), 475, 1044));
		scroll.addAction(finger.createPointerUp(0));
		
		driver.perform(Arrays.asList(scroll));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List Elements get added at runtime!\"]")))
		.click();
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
