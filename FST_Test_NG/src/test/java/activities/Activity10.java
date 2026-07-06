package activities;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity10 {
	// Declare webdriver
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the driver object
		driver = new FirefoxDriver();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// open the page
		driver.get("https://training-support.net/webelements/simple-form");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@DataProvider(name = "csvDataProvider")
	public Object[][] inputData() throws IOException, CsvException {
		// create the csv reader
		CSVReader reader = new CSVReader(new FileReader("src/test/resources/input.csv"));

		// make the reader skip the first line
		reader.skip(1);

		// read the data from the csv file
		List<String[]> inputData = reader.readAll();
		reader.close();

		// create the input dataset
		// this is the dataset that will be passed to the test functions
		Object[][] data = new Object[inputData.size()][];
		for (int i = 0; i < inputData.size(); i++) {
			data[i] = inputData.get(i);
		}

		// return the data
		return data;

	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "Selenium: Simple Form");

	}

	@Test(priority = 2, dataProvider = "csvDataProvider")
	public void formTest(String rows[]) {
		//locate the full name field and add the full name from the rows
		driver.findElement(By.id("full-name")).sendKeys(rows[0]);
		driver.findElement(By.id("email")).sendKeys(rows[1]);
		driver.findElement(By.name("event-date")).sendKeys(rows[2]);
		driver.findElement(By.id("additional-details")).sendKeys(rows[3]);
		
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		
		//confirm booking
		String message = driver.findElement(By.id("action-confirmation")).getText();
		assertEquals(message, "Your event has been scheduled!");
		

	}

	@AfterMethod
	public void resetPage() {
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}
