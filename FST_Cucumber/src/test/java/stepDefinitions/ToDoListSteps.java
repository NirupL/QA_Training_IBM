package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToDoListSteps extends BaseClass{
	@Given("user is on the To-Do list page")
	public void openToDoListPage() {
		driver.get("https://training-support.net/webelements/todo-list");
		
		assertEquals(driver.getTitle(),"Selenium: To-Do List");
	}
	
	@When("user adds the following tasks")
	public void addTasks(DataTable tasksTable) {
		//Covert the datatable to list
		List<String> tasks = tasksTable.asList();
		
		//to add each of the tasks 
		for(String task : tasks) {
			//find the input and add the task
			driver.findElement(By.id("todo-input")).sendKeys(task);
			//find the add button and click it
			driver.findElement(By.id("todo-add")).click();
		}
		
	}
	
	@Then("they can see the task added to the list")
		public void verifyTasks() {
			//get all the list tasks
			List<WebElement> list = driver.findElements(By.cssSelector("li.w-full"));
			
			//verify that number of that
			assertEquals(list.size(),5);
		}
	
}
