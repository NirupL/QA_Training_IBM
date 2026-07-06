package project;

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

public class ProjectActivity2 {
	//declare the objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		File testApp = new File("src/test/resources/ToDo.apk");
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		
		options.setApp(testApp.getAbsolutePath());
		
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
	
	@DataProvider(name = "data")
	public Object[][] values() {
		return new Object[][] { 
				{ "sports"},
				{ "technical"},

		};
	}
	
	@Test(dataProvider = "data")
	public void editCategories(String category) {
		//click the dropdown option
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		
		//wait until dropdown opens and click edit categories
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Edit categories…']")))
		.click();
		
		//wait until new button and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("CategoryListButtonNew")))
		.click();
		
		//find the input, clear and enter the category
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("CategoryListItemID"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("CategoryListItemID")))
		.sendKeys(category);
		
		//click the ok button
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("CategoryListButtonOK")))
		.click();
		
		//click all
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.CheckedTextView[@text='All']")))
		.click();
		
		//wait till that activity is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity 2']")));
		
		
		//wait until the home page and long click the 2nd one
		PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
		Sequence longPress = new Sequence(finger, 1); 
		
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), 324, 456));
		longPress.addAction(finger.createPointerDown(0));
		longPress.addAction(new Pause(finger, Duration.ofSeconds(2)));
		longPress.addAction(finger.createPointerUp(0));
		
		driver.perform(Arrays.asList(longPress));
		
		//click the dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailSpinnerCategory")))
		.click();
		
		//select the category from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.CheckedTextView[@text='"+category+"']")))
		.click();
		
		//click the ok button
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("DetailButtonOK")))
		.click();
		
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
