package project2.project2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.httpclient.util.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class httpTest {
	//htmlunit driver - without opening browser.
	//HtmlUnit is a good compromise between 
	//speed of execution and the CPU usage per thread while maintaining Selenium API. 

	private WebDriver driver;

	public httpTest(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void open_window() throws InterruptedException {
		int inc = 1;
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.cssSelector("ul li:nth-child(" + inc + ") a")).click();
			inc++;
		}
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

//		Thread.sleep(2000);
		driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals("Sign In | LinkedIn", driver.getTitle());
		driver.close();
		Thread.sleep(500);
		driver.switchTo().window(tabs2.get(2));
		Assert.assertEquals("Sauce Labs | Facebook", driver.getTitle());
		driver.close();
		Thread.sleep(500);
		driver.switchTo().window(tabs2.get(3));
		Assert.assertEquals("Sauce Labs (@saucelabs) / Twitter", driver.getTitle());
		driver.close();
		Thread.sleep(500);
		driver.switchTo().window(tabs2.get(0));
//	    driver.switchTo().window(tabs2.get(0));
	}

	public void check_http() throws IOException {
		List<WebElement> links = driver.findElements(By.cssSelector("ul li a"));
		int code = 0;
		SoftAssert a = new SoftAssert();
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			if (respCode < 400) {
				a.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code" + respCode);	
			}
			
		}
		a.assertAll();
	}
}
