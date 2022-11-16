package project2.project2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listen implements ITestListener{
//	ExtentTest test;	
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started, " + result.getName());
//		test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully Finished, " + result.getName());
//		extentTest.get().log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed, " + result.getName());
//		extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			
		}
		//get screenshot if failure caught.
//		try {
//			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped, " + result.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage, " + result.getName());
	}
 	public void onStart(ITestContext context) {
		System.out.println("This is on Start method, " + context.getOutputDirectory());
	}
 	public void onFinish(ITestContext context) {
		System.out.println("This is on Finish method, " + context.getPassedTests());
//		extent.flush();
	}
}
