package utilitiesPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports extentReport=new ExtentReports();
		
		ExtentSparkReporter extentsparkReporter = new ExtentSparkReporter("C:\\Users\\DELL\\eclipse-workspace\\Frameworks\\FrameWorks\\target\\reports\\TNReport.html");
		
		extentsparkReporter.config().setDocumentTitle("TNERreport");
		
		extentsparkReporter.config().setReportName("Tutorials Ninja Test Results");
		
		extentReport.attachReporter(extentsparkReporter);
		
		extentReport.setSystemInfo("OS",System.getProperty("os.name"));
		
		extentReport.setSystemInfo("Java",System.getProperty("java.version"));
		
		extentReport.setSystemInfo("user", System.getProperty("user.name"));
		
		extentReport.setSystemInfo("Selenium", "4.25.0");
		
		return extentReport;
	}

}
