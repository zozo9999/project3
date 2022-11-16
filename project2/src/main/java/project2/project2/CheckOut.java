package project2.project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	private WebDriver driver;
//	@FindBy(xpath="//a[@class='shopping_cart_link']")
//	public WebElement go_to_checkout;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']")
	public WebElement checkout;
	@FindBy(xpath="//input[@class='submit-button btn btn_primary cart_button btn_action']")
	public WebElement continue_after;
	@FindBy(name="firstName")
	public WebElement fname;
	@FindBy(name="lastName")
	public WebElement lname;
	@FindBy(name="postalCode")
	public WebElement zip;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement shopping_cart_bag;
//	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']")
//	public WebElement finish;
	@FindBy(xpath="//h2[@class='complete-header']")
	public WebElement confirm;
	
	By fname2 = By.xpath("//*[@id='first-name']");
	
//	By go_to_checkout = By.xpath("//a[@class='shopping_cart_link']");
//	By finish = By.xpath("//button[@class='btn btn_action btn_medium cart_button']");
	
	
	public CheckOut(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
//		PageFactory.initElements(driver, this);

	}
		
	public void go_to_checkout() {
//		String number_bag = shopping_cart_bag.getText();
//		if (number_bag.equals("1")) {
//			go_to_checkout.click();
//			driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
//		}
		String number_bag = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		
		int i = Integer.parseInt(number_bag);
		
		if (i > 0) {
//			go_to_checkout.click();	
			driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		} else {
			System.out.print("Your shopping bag is " + i);
		}

	}
	
	//go to check out
	public void check_out() {
		driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();
//		checkout.click();
	}
	
	public void enter_user_info(String fname, String lname, String zip) {
		driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys(zip);
//		this.fname.sendKeys(fname);
//		this.lname.sendKeys(lname);
//		this.zip.sendKeys(zip);
	}
	
	public void continue_after_checkout() {
		driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']")).click();
//		continue_after.click();
	}
	
	public void click_finish() {
		driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button']")).click();
//		finish.click();
	}
	
	public String confirmed() {
		String result = "";
//		result = confirm.getText();
		result = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		return result;
	}
	
	public void remove() {
		driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).click();
	}
}
