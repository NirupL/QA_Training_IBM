package project;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class ProjectActivity1 {
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
				{ "Complete Activity 1", "1", "6/17 – Tomorrow"},
				{ "Complete Activity 2", "1", "6/17 – Tomorrow"},
				{ "Complete Activity 3", "1", "6/18 – Thursday"},

		};
	}
	
	@Test(dataProvider = "data")
	public void addTasks(String description, String priority, String date) {
//		find the new button and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")))
		.sendKeys(description);
		
		
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).clear();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).sendKeys(priority);
		
		//click the none button
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
		
		
		//wait until the dialog box shows up
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/select_dialog_listview")));
		
		//select any of the dates
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='"+date+"']")
			)).click();
		
		//wait till ok button and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK"))).click();
		
		List<WebElement> tasks = driver.findElements(AppiumBy.id("ToDoEditDescription"));
		List<String> taskTexts = new ArrayList<>();
		
		for(WebElement task : tasks) {
			taskTexts.add(task.getText());
		}
		
		assertTrue(taskTexts.contains(description));
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
