package activities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Activity11 {
	// Declare webdriver
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the driver object
		driver = new FirefoxDriver();

//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// open the page
		driver.get("https://training-support.net/webelements/simple-form");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	private List<List<String>> readExcel(String filePath) throws FileNotFoundException, IOException {
		//create the base list 
		List<List<String>> data = new ArrayList<>();
		
		//create the workbook object
		Workbook excelFile = new XSSFWorkbook(new FileInputStream(filePath));
		
		//select the sheet from the workbook
		Sheet sheet1 = excelFile.getSheetAt(0);
		
		for(Row rows : sheet1) {
			//create a temp list to store row's data
			 // Skip header row
		    if (rows.getRowNum() == 0) {
		        continue;
		    }
			List<String> rowData = new ArrayList<>();
			for(Cell cells : rows) {
				rowData.add(cells.getStringCellValue());
			}
			data.add(rowData);
		}
		
		excelFile.close();
		return data;
	}

	@DataProvider(name = "excelDataProvider")
	public Object[][] inputData() throws FileNotFoundException, IOException  {
		// create the excel reader
		String filePath = "src/test/resources/sample.xlsx";
		List<List<String>>  inputData = readExcel(filePath);

		// create the input dataset
		// this is the dataset that will be passed to the test functions
		Object[][] data = new Object[inputData.size()][];
		for (int i = 0; i < inputData.size(); i++) {
			data[i] = inputData.get(i).toArray();
		}

		// return the data
		return data;

	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// assert the page title
		Assert.assertEquals(driver.getTitle(), "Selenium: Simple Form");

	}

	@Test(priority = 2, dataProvider = "excelDataProvider")
	public void formTest(String rows[]) {
		// locate the full name field and add the full name from the rows
		driver.findElement(By.id("full-name")).sendKeys(rows[0]);
		driver.findElement(By.id("email")).sendKeys(rows[1]);
		driver.findElement(By.name("event-date")).sendKeys(rows[2].replaceAll("\"", ""));
		driver.findElement(By.id("additional-details")).sendKeys(rows[3]);

		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();

		// confirm booking
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
