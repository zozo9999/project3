package project2.project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	@FindBy(name="user-name")
	private WebElement name;
	@FindBy(name="password")
	private WebElement pwd;
	@FindBy(name="login-button")
	public WebElement login;
	public Login (WebDriver driver) {
//		super(driver);

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void enter_username(String username) {
//		driver.findElement(By.name("user-name")).sendKeys(username);;
		
		name.sendKeys(username);
		
	}
	
	public void enter_password(String password) {
//		driver.findElement(By.name("password")).sendKeys(password);;
		pwd.sendKeys(password);
		
	}
	
	public void click_login() {
		//login
//		driver.findElement(By.name("login-button")).click();
		login.click();
	}
	
	public void log_out() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click(); // menu
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
	}
}
//String username = "";
//String passwords = "";
//ArrayList<String> lists_uname = new ArrayList<>();
//ArrayList<String> lists_pwd = new ArrayList<>();
//
//public Login() throws IOException {
//	// TODO Auto-generated constructor stub
//	PageFactory.initElements(driver, this);
//	File file = new File("C:\\Users\\Junghwan Shin\\Desktop\\Book1.xlsx");
//	FileInputStream inputStream = new FileInputStream(file);
//	Workbook guru99Workbook = null;
//
//	String filename = "Book1.xlsx";
//	String fileExtensionName = filename.substring(filename.indexOf("."));
//
//	if(fileExtensionName.equals(".xlsx"))	{
//		guru99Workbook = new XSSFWorkbook(inputStream);
//	} else if(fileExtensionName.equals(".xls")){
//		guru99Workbook = new HSSFWorkbook(inputStream);
//	}
//	Sheet guru99Sheet = guru99Workbook.getSheet("Sheet1");
//	
//	DataFormatter formatter = new DataFormatter();
//	
//	for (int i=1; i <= guru99Sheet.getLastRowNum(); i++) {
//        Row r = guru99Sheet.getRow(i);
//        if (r == null) { 
//           // empty row, skip
//        } else {
//           username = formatter.formatCellValue(r.getCell(0));
//           passwords =  formatter.formatCellValue(r.getCell(1));
//           lists_uname.add(username);
//           lists_pwd.add(passwords);
//        }
//	}
//}
