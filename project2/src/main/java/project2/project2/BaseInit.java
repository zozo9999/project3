package project2.project2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class BaseInit {
	private static WebDriver driver;
	
	@FindBy(id="react-burger-menu-btn")
	public WebElement menubar;
	@FindBy(id="inventory_sidebar_link")
	public WebElement all_items;
	@FindBy(id="about_sidebar_link")
	public WebElement about;
	@FindBy(id="logout_sidebar_link")
	public WebElement logout;
	@FindBy(id="reset_sidebar_link")
	public WebElement reset_app;
	
	public BaseInit(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
	}
		
	public void click_menu_bar() {
		
	}
	
	public void go_back_to_home() {
		
	}
	
	public void reset() {
		menubar.click();
		reset_app.click();
	}
}
