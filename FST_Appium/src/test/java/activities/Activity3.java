package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	//Declare the objects
		AppiumDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void setUp() throws MalformedURLException, URISyntaxException {
			//set the path to the file
			File testApp = new File("src/test/resources/Calculator.apk");
			//set the desired capabilities
			UiAutomator2Options options = new UiAutomator2Options();
			//options to select platform
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			//option to install/open the required app
			options.setApp(testApp.getAbsolutePath());
			//option to prevent app reset
			options.noReset();
			
			
			//set the Appium server url
			URL serverUrl = new URI("http://127.0.0.1:4723").toURL();
			
			//initialize the driver
			driver = new AndroidDriver(serverUrl, options);
		}
		
		@BeforeMethod
		public void clearResults() {
			//locate and tap the clear button
			driver.findElement(AppiumBy.accessibilityId("clear")).click();
		}
		
		@Test
		public void testPlus() {
			//interactions with the app
//			System.out.println("App opened");
			driver.findElement(AppiumBy.accessibilityId("5")).click();
			driver.findElement(AppiumBy.accessibilityId("plus")).click();
			driver.findElement(AppiumBy.accessibilityId("9")).click();
			
			String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview")).getText();
			System.out.println("Addition : " +result);
			assertEquals("14",result);
		}
		
		@Test
		public void testMinus() {
			//interactions with the app
//			System.out.println("App opened");
			driver.findElement(AppiumBy.accessibilityId("1")).click();
			driver.findElement(AppiumBy.accessibilityId("0")).click();
			driver.findElement(AppiumBy.accessibilityId("minus")).click();
			driver.findElement(AppiumBy.accessibilityId("5")).click();
			
			String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview")).getText();
			System.out.println("Subtraction : " +result);
			assertEquals("5",result);
		}
		
		@Test
		public void testMultiply() {
			//interactions with the app
//			System.out.println("App opened");
			driver.findElement(AppiumBy.accessibilityId("5")).click();
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			driver.findElement(AppiumBy.accessibilityId("1")).click();
			driver.findElement(AppiumBy.accessibilityId("0")).click();
			driver.findElement(AppiumBy.accessibilityId("0")).click();
			
			String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview")).getText();
			System.out.println("Multiply : " +result);
			assertEquals("500",result);
		}
		
		@Test
		public void testDiv() {
			//interactions with the app
//			System.out.println("App opened");
			driver.findElement(AppiumBy.accessibilityId("5")).click();
			driver.findElement(AppiumBy.accessibilityId("0")).click();
			driver.findElement(AppiumBy.accessibilityId("divide")).click();
			driver.findElement(AppiumBy.accessibilityId("2")).click();
			
			String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview")).getText();
			System.out.println("Division :" +result);
			assertEquals("25",result);
		}
		
		@AfterClass
		public void tearDown() {
			//close the app
			driver.quit();
		}
}
