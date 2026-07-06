package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	//Declare the objects
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
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		@Test
		public void testMethod() {
			//open a page in the browser
			driver.get("https://training-support.net");
			//verify homepage heading
			String homePageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]")).getText();
			assertEquals("Training Support", homePageHeading);
			
			//locate and click the about us link
			driver.findElement(AppiumBy.accessibilityId("About Us")).click();
			
			//verify the heading of the about page
			String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText();
			assertEquals("About Us", aboutPageHeading);
			
		}
		
		@AfterClass
		public void tearDown() {
			//close the app
			driver.quit();
		}
}
