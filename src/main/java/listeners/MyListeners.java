package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilitiesPackage.ExtentReporter;
import utilitiesPackage.Utilities;

public class MyListeners implements ITestListener {
	ExtentReports report;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest=report.createTest(result.getName());	
		extentTest.log(Status.INFO, result.getName()+ " test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+ " Test got passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		
		extentTest.log(Status.FAIL, result.getName()+" test got failed");
		try {
		 driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	}catch(Exception e) {
		e.printStackTrace();
	}
		String screenshotPath = Utilities.takeScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(screenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.SKIP,result.getName()+" test got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		
		report=ExtentReporter.getExtentReport();	
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		String extentReportPath="C:\\Users\\DELL\\eclipse-workspace\\Frameworks\\FrameWorks\\target\\reports\\TNReport.html";
		File extentReportFile =new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
