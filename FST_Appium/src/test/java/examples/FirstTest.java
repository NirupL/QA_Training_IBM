package examples;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FirstTest {
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
		
		// Set the desired capabilities for IOS
//		XCUITestOptions options = new XCUITestOptions();
//		// Options to select platform
//		options.setPlatformName("ios");
//		options.setAutomationName("XCUITest");
//		// Option to install/open the required app
//		options.setApp("testApp.ipa"); // Provide Absolute Path to .ipa file
//		driver = new IOSDriver(serverUrl, options);
		
		//set the Appium server url
		URL serverUrl = new URI("http://127.0.0.1:4723").toURL();
		
		//initialize the driver
		driver = new AndroidDriver(serverUrl, options);
	}
	
	@Test
	public void testMethod() {
		//interactions with the app
		System.out.println("App opened");
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}

}
