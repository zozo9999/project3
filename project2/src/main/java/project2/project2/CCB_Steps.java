package project2.project2;

import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class CCB_Steps {
	private static WebDriver driver;
	Login login;
	Sorting sort;
	public CCB_Steps() {
		// TODO Auto-generated constructor stub
	}

	@Given("I am on the main home page")
	public void i_am_on_the_main_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
		
		BasicConfigurator.configure();
		Logger log = Logger.getLogger("devpinoyLogger");
	}
	
	@When("Click Login")
	public void click_login() {
	    // Write code here that turns the phrase above into concrete actions
		login = new Login(driver);
		login.enter_username("standard_user");
		login.enter_password("secret_sauce");
		login.click_login();
		
		List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		int number_products = list_products.size();
		System.out.println("Verifying login is the number of products: " + number_products);
		AssertJUnit.assertEquals(number_products, 6);
	}
	
	@When("click sorting A to Z")
	public void click_sorting_a_to_z() {
	    // Write code here that turns the phrase above into concrete actions
		sort = new Sorting(driver);
		sort.click_list_sort("A to Z"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Sauce Labs Backpack");
		AssertJUnit.assertEquals(last_product, "Test.allTheThings() T-Shirt (Red)");    
	}
	
	@Then("Products become A to Z")
	public void products_become_a_to_z() {
	    // Write code here that turns the phrase above into concrete actions
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		System.out.println(first_product);
		System.out.println(last_product);
	}
	
	@When("click sorting Z to A")
	public void click_sorting_z_to_a() {
	    // Write code here that turns the phrase above into concrete actions
		sort = new Sorting(driver);
		sort.click_list_sort("Z to A"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Test.allTheThings() T-Shirt (Red)");
		AssertJUnit.assertEquals(last_product, "Sauce Labs Backpack");
		
	}
	
	@Then("Products become Z to A")
	public void products_become_z_to_a() {
	    // Write code here that turns the phrase above into concrete actions
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		System.out.println(first_product);
		System.out.println(last_product);
	}
	
	@When("click sorting L to H")
	public void click_sorting_l_to_h() {
	    // Write code here that turns the phrase above into concrete actions
		sort = new Sorting(driver);
		sort.click_list_sort("Low"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Sauce Labs Onesie");
		AssertJUnit.assertEquals(last_product, "Sauce Labs Fleece Jacket");
	}
	
	@Then("Products become L to H")
	public void products_become_l_to_h() {
	    // Write code here that turns the phrase above into concrete actions

	}
	
	@When("click sorting H to L")
	public void click_sorting_h_to_l() {
	    // Write code here that turns the phrase above into concrete actions
		sort = new Sorting(driver);
		sort.click_list_sort("High"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Sauce Labs Fleece Jacket");
		AssertJUnit.assertEquals(last_product, "Sauce Labs Onesie");
	}
	
	@Then("Products become H to L")
	public void products_become_h_to_l() {
	    // Write code here that turns the phrase above into concrete actions

	}
}
