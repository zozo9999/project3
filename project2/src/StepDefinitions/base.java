
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class base {
	public static WebDriver driver;
	public base() {
		// TODO Auto-generated constructor stub
	}
	
	public static WebDriver getdriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\Users\\Junghwan Shin\\Git\\project1\\mavenProject\\src\\test\\java\\StepDefinitions\\globalvariable");
		prop.load(fi);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
