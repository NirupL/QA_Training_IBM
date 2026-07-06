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

public class ProjectActivity3 {
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
	
	
	@Test
	public void editCategories() {
		
		driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id=\"com.xmission.trevin.android.todo:id/todo_list\"]/android.widget.LinearLayout[1]/android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"]"))
		.click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id=\"com.xmission.trevin.android.todo:id/todo_list\"]/android.widget.LinearLayout[1]/android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"]"))
		.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xmission.trevin.android.todo:id/menuShowCompleted")))
		.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.xmission.trevin.android.todo:id/menuShowCompleted")))
		.click();
	
		String result = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Complete Activity 3\"]")))
						.getText();
		
		assertEquals(result, "Complete Activity 3");
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
