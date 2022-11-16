package project2.project2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class duplicate_products {
	WebDriver driver;
	ArrayList<String> p;
	By name = By.xpath("");
	public duplicate_products(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void check_product_images() {
		//img[@class="inventory_item_img"]
		p = new ArrayList<String>();
		List<WebElement> gg = driver.findElements(By.xpath("//img[@class=\"inventory_item_img\"]"));
		
		for(WebElement g : gg) {
			if(g.getAttribute("class").equals("inventory_item_img")) {
				p.add("inventory_item_img");
			}	
		}
		System.out.print(p);
	}
	
	public void click_image() throws InterruptedException {
		
		List<WebElement> list_images = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(int i = 1; i < 7; i++) {
			driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[" + i + "]")).click();
			Thread.sleep(1500);
			driver.navigate().back();
		
		}
		
	}
}
