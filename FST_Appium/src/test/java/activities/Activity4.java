package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

public class Activity4 {
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
				wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//open the page
				driver.get("https://training-support.net/webelements/sliders");
			}
			
			@DataProvider(name = "coordinates")
			public Object[][] values() {
				return new Object[][] { 
						{ "0.333", "25%" },
						{ "0.663", "75%" },

				};
			}
			
			@Test(dataProvider = "coordinates")
			public void testVolume25(String xAxis, String result) {
				//calculate the phone screen dimensions
				Dimension dims = driver.manage().window().getSize();
				
				//calculate the start and end points
				Point start = new Point((int)(0.5* dims.getWidth()),(int)(0.72* dims.getHeight()));
				Point end = new Point((int)(Float.valueOf(xAxis)* dims.getWidth()),(int)(0.72* dims.getHeight()));
				
				//wait for the bar to load
				wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.SeekBar[@resource-id='volume']")));
				
				//drag the slider to the 25% point
				new ActionsBase().doSwipe(driver, 2000, start, end);
				
				String volumeText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'%')]")).getText();
				assertEquals(volumeText,result);
			
			}
			
			
			@AfterClass
			public void tearDown() {
				//close the app
				driver.quit();
			}
}
