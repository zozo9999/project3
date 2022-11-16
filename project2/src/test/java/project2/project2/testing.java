package project2.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testing {
	public WebDriver driver; 
	Login login;
	Sorting sort;
	CheckOut checkout; // check out
	public testing() {
		// TODO Auto-generated constructor stub
	}
	@Given("^Login \"([^\"]*)\", Sorting tab is seen.$")
    public void login_sorting_tab_is_seen(String username) throws Throwable {
		login = new Login(driver);
		System.out.println(username);
		if(username.equals("performance_glitch_user")) {
			login.enter_username(username);
			login.enter_password("secret_sauce");
			login.click_login();
			Thread.sleep(5000);
		} else {
			login.enter_username(username);
			login.enter_password("secret_sauce");
			login.click_login();
		}
//		login.enter_username(username);
//		login.enter_password("secret_sauce");
//		login.click_login();
//		Thread.sleep(500);
//		String n =driver.findElement(By.cssSelector("error-message-container error")).getAttribute("class");
//		System.out.println(n);
//		if(n.equalsIgnoreCase("error-message-container error")) {
//			driver.quit();
//		}
    }
	
	@Given("Showing the list when a user clicks the tab")
	public void showing_the_list_when_a_user_clicks_the_tab() {
		// Write code here that turns the phrase above into concrete actions
		
	}
	
	@When("^click \"([^\"]*)\" is clicked.$")
    public void click_something_is_clicked(String strArg1) throws Throwable {
		sort = new Sorting(driver);
		sort.click_list_sort(strArg1);
		
    }
	
	@Then("^Vertify that if \"([^\"]*)\" is sorted")
	public void Vertify_A_to_Z(String strArg1) throws Throwable {
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Sauce Labs Backpack");
		AssertJUnit.assertEquals(last_product, "Test.allTheThings() T-Shirt (Red)");
		
    }
	
	
}
