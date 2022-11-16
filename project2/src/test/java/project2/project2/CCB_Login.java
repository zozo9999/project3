package project2.project2;

import io.cucumber.java.en.Given;
import junit.framework.Assert;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CCB_Login {
	private WebDriver driver;
	Login login;	
	@Given("user is on login page")
	public void user_is_oon_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Inside Step - user is on login page");
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		login = new Login(driver);
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user enter unsername and password");
		login.enter_username("standard_user");
		login.enter_password("secret_sauce");
		
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user cliks login button");
		login.click_login();
		
		List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		int number_products = list_products.size();
		System.out.println("Verifying login is the number of products: " + number_products);
		Assert.assertEquals(number_products, 6);
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user navigates to home page");
		driver.quit();
	}


}
