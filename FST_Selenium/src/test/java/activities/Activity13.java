package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity13 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		try {
			
			driver.get(" https://training-support.net/webelements/tables");
			
			System.out.println("Title is  :"+driver.getTitle());
			
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th"));
			
			System.out.println("Rows are : "+rows.size()+ " and coulumns are : "+columns.size());
			
			//third row data
			System.out.println("Third row :" +driver.findElement(By.xpath("//table/tbody/tr[3]")).getText());
			
			//to get each cell from third row
			List<WebElement> thirdRowCells = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
			for(WebElement cell : thirdRowCells) {
				System.out.println(cell.getText());
			}
			
			//second row second column
			System.out.println("Second row second column :" +driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally {
			driver.quit();
		}
				

	}

}
