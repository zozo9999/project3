
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;

import com.eCommerce.test.CheckOut;
import com.eCommerce.test.Login;
import com.eCommerce.test.Sorting;
import com.google.common.util.concurrent.AbstractExecutionThreadService;

import io.cucumber.java.en.*;

public class COB_sorting_2 {
	public WebDriver driver; 
	Login login;
	Sorting sort;
	CheckOut checkout; // check out

	public COB_sorting_2() {
		// TODO Auto-generated constructor stub
	}
	@Given("^validate brwoser$")
    public void validate_brwoser() throws Throwable {
		System.out.println("Validate chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
//		ChromeOptions chromeOptions = new ChromeOptions();
//	    chromeOptions.addArguments("--headless");
//	    chromeOptions.setExperimentalOption("useAutomationExtension", false);	    
	//  chromeOptions.addArguments("no-sandbox");
//	    driver= new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
//		driver.get("https://www.saucedemo.com/");
//		driver = base.getdriver();		

		//SSl certificates

		//Desired capabilities=
		//general chrome profile
//		DesiredCapabilities ch=DesiredCapabilities(driver);
		//ch.acceptInsecureCerts();
//		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		//Belows to your local browser
//		ChromeOptions c= new ChromeOptions();
//		c.merge(ch);

		//cmd mvn test -DCucumber.options(--tags @SmokeTest)
		//jenkins parameters : make tag selection list
		//test -DCucumber.options(--tags @SmokeTest) @"$Tags"
    }

    @When("^browser is triggared$")
    public void browser_is_triggared() throws Throwable {
    	System.out.println("The chrome browser is triggared");        
    }

    @Then("^check if brwoser is started$")
    public void check_if_brwoser_is_started() throws Throwable {
    	System.out.println("The chrome browser has started");
    }
	
	@Given("^Login (.+), Sorting tab is seen.$")
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
	
	@Then("^Products are sorted from \"([^\"]*)\" and (.+), (.+), (.+).$")
    public void products_are_sorted_from_something_and_(String strArg1, String fname, String lname, String zip) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		if (strArg1.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)")) {
			String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
			String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
			AssertJUnit.assertEquals(first_product, "Sauce Labs Backpack");
			AssertJUnit.assertEquals(last_product, "Test.allTheThings() T-Shirt (Red)");
			checkout = new CheckOut(driver);
			checkout.go_to_checkout();
			checkout.check_out();
			checkout.enter_user_info(fname, lname, zip);
			driver.quit();	
		} else if (strArg1.equalsIgnoreCase("Sauce Labs Backpack")) {
			String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
			String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
			AssertJUnit.assertEquals(first_product, "Test.allTheThings() T-Shirt (Red)");
			AssertJUnit.assertEquals(last_product, "Sauce Labs Backpack");
			driver.quit();			
		} else if (strArg1.equalsIgnoreCase("low to high")) {
			String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
			String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[6]")).getText();
			AssertJUnit.assertEquals(first_product, "$7.99");
			AssertJUnit.assertEquals(last_product, "$49.99");
			driver.quit();			
		} else if (strArg1.equalsIgnoreCase("high to low") ) {
			String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
			AssertJUnit.assertEquals(first_product, "$29.99");
			driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]")).click();
			checkout = new CheckOut(driver);
			checkout.go_to_checkout();
			checkout.check_out();
			checkout.enter_user_info(fname, lname, zip);
			checkout.continue_after_checkout();
			checkout.click_finish();
//			driver.quit();
		}
	}

//	@When("Click Sorting Z to A is clicked.")
//	public void click_sorting_z_to_a_is_clicked() {
//		// Write code here that turns the phrase above into concrete actions
//		sort = new Sorting(driver);
//		sort.click_list_sort("Z to A");
//	}
//
//	@Then("Products are sorted from Z to A.")
//	public void products_are_sorted_from_z_to_a() {
//		// Write code here that turns the phrase above into concrete actions
//		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
//		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
//		AssertJUnit.assertEquals(first_product, "Test.allTheThings() T-Shirt (Red)");
//		AssertJUnit.assertEquals(last_product, "Sauce Labs Backpack");
//		driver.quit();
//	}
//
//	@When("Click Sorting low to high is clicked.")
//	public void click_sorting_low_to_high_is_clicked() {
//		// Write code here that turns the phrase above into concrete actions
//		sort = new Sorting(driver);
//		sort.click_list_sort("Low");
//		driver.quit();
//	}
//
//	@Then("Products are sorted from low to high")
//	public void products_are_sorted_from_low_to_high() {
//		// Write code here that turns the phrase above into concrete actions
//		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
//		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[6]")).getText();
//		AssertJUnit.assertEquals(first_product, "$7.99");
//		AssertJUnit.assertEquals(last_product, "$49.99");
//		driver.quit();
//	}
//
//	@When("Click Sorting high to low is clicked.")
//	public void click_sorting_high_to_low_is_clicked() {
//		// Write code here that turns the phrase above into concrete actions
//		sort = new Sorting(driver);
//		sort.click_list_sort("High");
//	}
//
//	@Then("Products are sorted from high to low")
//	public void products_are_sorted_from_high_to_low() {
//		// Write code here that turns the phrase above into concrete actions
//		
//		driver.quit();
//	}


}
