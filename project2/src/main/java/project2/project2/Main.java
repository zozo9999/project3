package project2.project2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.cache.AbstractCache;

import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

//Properties prop=new Properties();
//FileInputStream fis =new FileInputStream("C:\\Users\\Owner\\CoreJava\\CoreJava\\src\\data.properties");
//prop.load(fis);
//System.out.println(prop.getProperty("browser"));
//System.out.println(prop.getProperty("url"));
//prop.setProperty("browser", "firefox");
//System.out.println(prop.getProperty("browser"));
//FileOutputStream fos =new FileOutputStream("C:\\Users\\Owner\\CoreJava\\CoreJava\\src\\data.properties");
//prop.store(fos, null);

//plugin = help maven compile
// suitexmlfile to run testng (test cases can be maintained if removing two test cases in xml, the testng
//will be executing remaining test cases without two cases.
//mvn Dtest = test case name (run a signle test case)

//profile to build a different environment to run different test case like multiple suitexml files
//mvn test -PSmoke or -PRegression (id is the name in the profile of maven)
@Listeners(Listen.class)
public class Main {
	public WebDriver driver;
	Login login;
	Sorting sort;
	httpTest socials;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	public WebElement menubar;
	Logger log = (Logger) LogManager.getLogger(Main.class);

	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	public WebElement reset_app;

	// Before Test, set up init
//	@Parameters("browser")

	// ExtentReports, ExtentSparkReporter
//	String path =System.getProperty("user.dir")+"\\reports\\index.html";
//	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//	reporter.config().setReportName("Web Automation Results");
//	reporter.config().setDocumentTitle("Test Results");
//	extent =new ExtentReports();
//	extent.attachReporter(reporter);
//	extent.setSystemInfo("Tester", "Rahul Shetty");

//	@Test
//	ExtentTest test= extent.createTest("Initial Demo");
//	//test.fail("Result do not match");
//	extent.flush();

	@BeforeTest(alwaysRun = true)
	public void bfTest() throws IOException {
//		if(browser.equalsIgnoreCase("firefox")){
//			
//		}

		// javascript authorization
		// http://admin:admin@website address.com/ this will be complete without asking
		// authrization.
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		// chromeoption - headless = not opening browser.

		log.info("window maximinied");
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("Information");
		driver.get(url);
		log.debug("opening webiste");
		log.debug("entring weight");

//		BasicConfigurator.configure();
//		Logger log = Logger.getLogger("devpinoyLogger");
	}

	// Verify login sucessfully
	// enter different login username
	// four different username
	// (dataProvider ="data-provider")
	@Test(groups = { "TC01" }, dataProvider = ("data-provider"))
	public void test_case_01(String uname, String pwd) throws InterruptedException {
		login = new Login(driver);

		login.enter_username(uname);
		login.enter_password(pwd);
		login.click_login();

		Thread.sleep(1500);
		duplicate_products d = new duplicate_products(driver);
		d.check_product_images();
//		List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
//		int number_products = list_products.size();
//		System.out.println("Verifying login is the number of products: " + number_products);
//		AssertJUnit.assertEquals(number_products, 6);
		Assert.assertEquals("Swag Labs", driver.getTitle());
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] {
				{ "standard_user", "secret_sauce" } /*
													 * , {"locked_out_user", "secret_sauce"} , {"problem_user",
													 * "secret_sauce"}, {"performance_glitch_user", "secret_sauce"}
													 */ };
	}

	// Vertify that user tries to attempt with different information.

	// Verify sorting A to Z
	@Test(groups = { "TC02" })
	public void test_case_02() {
		sort = new Sorting(driver);
		sort.click_list_sort("A to Z"); // click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
//		log.info("Test case 02");
		AssertJUnit.assertEquals("Sauce Labs Backpack", first_product);
		AssertJUnit.assertEquals("Test.allTheThings() T-Shirt (Red)", last_product);
	}

	// Verify sorting Z to A
	@Test(groups = { "TC03" })
	public void test_case_03() {
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("Z to A"); // click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Test.allTheThings() T-Shirt (Red)");
		AssertJUnit.assertEquals(last_product, "Sauce Labs Backpack");
	}

	// Verify sorting price low to high
	@Test(groups = { "TC04" })
	public void test_case_04() {
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("Low"); // click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "$7.99");
		AssertJUnit.assertEquals(last_product, "$49.99");
	}

	// Verify sorting price high to low
	// Special verifying.
	// Go over each price with assertion.
	@Test(groups = { "TC05" })
	public void test_case_05() {
		ArrayList ar = new ArrayList<String>();
		ArrayList actual_ar = new ArrayList<String>();
		actual_ar.add("$49.99");
		actual_ar.add("$29.99");
		actual_ar.add("$15.99");
		actual_ar.add("$15.99");
		actual_ar.add("$9.99");
		actual_ar.add("$7.99");
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("High"); // click A to Z
		List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for (WebElement a : list_products) {
			ar.add(a.getText());
		}
		for (int i = 0; i < ar.size(); i++) {
			AssertJUnit.assertEquals(ar.get(i), actual_ar.get(i));
		}

	}

	// Verify to be click to buy product and remove
	@Test(groups = { "TC06" })
	public void test_case_06() throws InterruptedException {
		ArrayList ar = new ArrayList<String>();
		ArrayList actual_ar = new ArrayList<String>();
		// add button
		List<WebElement> list_products = driver
				.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

		for (WebElement a : list_products) {
			Assert.assertEquals(a.getText(), "ADD TO CART");
			a.click();
		}
		Assert.assertEquals("6", driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText());

		// remove button
		List<WebElement> list_products2 = driver
				.findElements(By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']"));
		Thread.sleep(1000);
		for (WebElement a : list_products2) {
			Assert.assertEquals(a.getText(), "REMOVE");
			a.click();
		}
	}

	// Verify buy products and it is correct number of products in the cart.
	@Test(groups = { "TC07" })
	public void test_case_07() {
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));
		first_product.click();
		String number_of_products = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		AssertJUnit.assertEquals(number_of_products, "1");
	}

	// verify more than one to be able to buy product
	@Test(groups = { "TC08" })
	public void test_case_08() {
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		String number_of_products = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		AssertJUnit.assertEquals(number_of_products, "2");
	}

	// click each image and vertify that user accesses the image url.
	@Test(groups = { "TC08_1" })
	public void test_case_08_1() throws InterruptedException {
		ArrayList actual_ar = new ArrayList<String>();

		duplicate_products d = new duplicate_products(driver);
		driver.navigate().refresh();
		d.click_image();

	}

	// vertify check out from one product
	@Test(groups = { "TC09" })
	public void test_case_09() throws InterruptedException {
		// we need to reset because the web application is stuck with chosen options.
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='reset_sidebar_link']")).click();
		driver.navigate().refresh();
		CheckOut checkout = new CheckOut(driver);
		// shopping_cart_link
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[5]"));
		first_product.click();
		Thread.sleep(2000);

		checkout.go_to_checkout();
		Thread.sleep(1500);
		checkout.check_out();
		checkout.enter_user_info("James", "James", "2000");
		checkout.continue_after_checkout();
		checkout.click_finish();
		String recipt = checkout.confirmed();
		AssertJUnit.assertEquals(recipt, "THANK YOU FOR YOUR ORDER");
		// Back to home
		driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small']")).click();

	}

	// vertify removing products in the checkout page.
	@Test(groups = { "TC10" })
	public void test_case_10() {
		CheckOut checkout = new CheckOut(driver);
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		checkout.go_to_checkout();
		String classname = "";
		while (true) {
			checkout.remove();
			classname = driver.findElement(By.xpath("//div[@class='cart_contents_container']/div/div/div[3]"))
					.getAttribute("class");
			System.out.println(classname);
			break;
		}
		Assert.assertEquals(classname, "removed_cart_item");

	}

	// vertify cannot proceed without fname, lname, zip
	// Test case 11 is not good because zip code allows text instead of allowing
	// only number.
	@Test
	public void test_case_11() {

	}

	// Vertify social media icons
	// facebook
	// twitter
	// linkedin
	@Test(groups = { "http", "TC12" })
	public void test_case_12() throws IOException, InterruptedException {
		socials = new httpTest(driver);
		socials.open_window();
	}

//	@Test(groups= {"http"})
//	public void test_case_12_bonus_response () throws IOException {
//		socials = new httpTest(driver);
//		socials.check_http();
//	}

	// vertify if item is removed when refreshing
	@Test(groups = {  "TC13" })
	public void test_case_13() {
		driver.navigate().back();
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		WebElement second_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[3]"));
		second_product.click();
		driver.navigate().refresh();
		String exist = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		AssertJUnit.assertEquals(exist, "2");

	}

	// vertify if none remove clickable is free after reset
	@Test(groups = { "TC14" })
	public void test_case_14() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='reset_sidebar_link']")).click();

		List<WebElement> list_btns = driver
				.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
		for (WebElement web : list_btns) {
			if (web.getAttribute("data-test").equals("remove-sauce-labs-backpack")) {
				System.out.println("This test needs to be moving to defect management tool");
			}
		}
	}

	// vertify if a user with problem_user has duplicate product images
	@Test(groups = { "TC15" })
	public void test_case_15() throws InterruptedException {
		driver.navigate().refresh();
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		String number_of_products = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		driver.navigate().refresh();
		Login login = new Login(driver);
		login.log_out();
		login.enter_username("problem_user");
		login.enter_password("secret_sauce");
		login.click_login();

		Thread.sleep(1500);
		String number_of_products_2 = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		Assert.assertEquals(number_of_products, number_of_products_2);
	}

	// vertify if a user with problem_user can enter into payment system with
	// personal info
	@Test(groups= {"TC16"})
	public void test_case_16() throws InterruptedException {
		Login login = new Login(driver);
//		login.log_out();
		login.enter_username("problem_user");
		login.enter_password("secret_sauce");
		login.click_login();
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		CheckOut ch = new CheckOut(driver);
		ch.go_to_checkout();
		ch.check_out();
		ch.enter_user_info("test", "test","test");
		ch.continue_after_checkout();
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText();
		Assert.assertEquals(name, "Error: Last Name is required");
	}

	// vertify if locked_out_user can log in
	@Test (groups= {"locked_out_user", "TC17"})
	public void test_case_17() throws InterruptedException {
		Login login = new Login(driver);
//		login.log_out();
		login.enter_username("locked_out_user");
		login.enter_password("secret_sauce");
		login.click_login();
		Thread.sleep(1500);
		// need thread sleep
//		String error = driver.findElement(By.xpath("div[@class='error-message-container error']"))
//				.getAttribute("class");
//		System.out.println(error);
//		if (error.equals("error-message-container error")) {
//			driver.quit();
//		}
		// error-message-container error
		String name = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
		Assert.assertEquals(name, "Epic sadface: Sorry, this user has been locked out.");
	}

	// verify if performance_glitch_user user has glitch for 5 seconds
	@Test(groups= {"TC18"})
	public void test_case_18() throws InterruptedException {
		Login login = new Login(driver);
//		login.log_out();
		login.enter_username("performance_glitch_user");
		login.enter_password("secret_sauce");
		login.click_login();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	// Vertify that if checkout info still remains when refreshing
	@Test(groups= {"TC19"})
	public void test_case_19() throws InterruptedException {
		Login login = new Login(driver);
//		login.log_out();
		login.enter_username("standard_user");
		login.enter_password("secret_sauce");
		login.click_login();
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		WebElement second_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[3]"));
		second_product.click();
		CheckOut ch = new CheckOut(driver);
		ch.go_to_checkout();
		ch.check_out();
		ch.enter_user_info("test", "test","test");
		ch.continue_after_checkout();
		driver.navigate().refresh();
		String number_of_products = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		AssertJUnit.assertEquals(number_of_products, "2");		
	}

	// Vertify that if total price is correct from the products
	@Test(groups= {"TC20"})
	public void test_case_20() throws InterruptedException {
		Login login = new Login(driver);
//		login.log_out();
		login.enter_username("standard_user");
		login.enter_password("secret_sauce");
		login.click_login();
		WebElement first_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		WebElement second_product = driver
				.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[3]"));
		second_product.click();
		CheckOut ch = new CheckOut(driver);
		ch.go_to_checkout();
		ch.check_out();
		ch.enter_user_info("test", "test","test");
		ch.continue_after_checkout();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		ArrayList ar = new ArrayList<String>();		
		for (WebElement g : list) {
			ar.add(g.getText());
		}
		
		double g = 0;
		double total = 0;
		String name = "";
		String tax = "";
		for (int i = 0; i < ar.size(); i++) {
			name = (String) ar.get(i);
			g = Double.valueOf(name.substring(1));
			
			total = total + g;
		}
//		System.out.println(round(total, 2));
		String op = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")).getText();
		tax = op.substring(6, 10);
		String totals = "";
		double b = round(total, 2) + Double.valueOf(tax);
		totals = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")).getText();
		
		Assert.assertEquals(round(total, 2) + Double.valueOf(tax), round(Double.valueOf(totals.replace("Total: $", "")), 2));
		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	@AfterTest(alwaysRun = true)
	public void afTest() throws IOException {
		driver.quit();
	}

//	@DataProvider (name = "data-provider")
//    public Object[][] dpMethod(){
//		return new Object[][] {
//			{"standard_user"}, 
//			{"locked_out_user"}, 
//			{"problem_user"}, 
//			{"performance_glitch_user"}, 
//		 };
//    }

//WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
//System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
//WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
//driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
//WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
//driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
//WebElement rdb = driver.findElement(By.id("inlineRadio1"));
//System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

	// Switching Window
//	driver.switchTo().newWindow(WindowType.WINDOW);
//	Set<String> handles=driver.getWindowHandles();
//	Iterator<String> it=handles.iterator();
//	String parentWindowId = it.next();
//	String childWindow =it.next();
//	driver.switchTo().window(childWindow);
//	driver.get("https://rahulshettyacademy.com/");
//	String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
//	.get(1).getText();
//	driver.switchTo().window(parentWindowId);
//	WebElement name=driver.findElement(By.cssSelector("[name='name']"));
//	name.sendKeys(courseName);
//	//Screenshot
//	File file=name.getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(file, new File("logo.png"));
//	//driver.quit();
//	//GEt Height & Width
//	System.out.println(name.getRect().getDimension().getHeight());
//	System.out.println(name.getRect().getDimension().getWidth());
}
