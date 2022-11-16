package project2.project2;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Sorting {
	private WebDriver driver;
	@FindBy(xpath="//select[@class='product_sort_container']")
	public WebElement list_sort;
	
	public Sorting(WebDriver driver) {
 		// TODO Auto-generated constructor stub
		this.driver = driver;
//		PageFactory.initElements(this.driver, this);	
	}
	
	//pick up one for sorting.
	public void click_list_sort(String name) {
		Select options = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		if (name.equals("A to Z")) {
			options.selectByIndex(0);
		} else if (name.equals("Z to A" )) {
			options.selectByIndex(1);
		} else if (name.equals("low to high")) {
			options.selectByIndex(2);
		} else if (name.equals("high to low")) {
			
		} else if (name.equals("Low")) {
			options.selectByIndex(2);
		} else if (name.equals("High")) {
			options.selectByIndex(3);
		}
	}

}
